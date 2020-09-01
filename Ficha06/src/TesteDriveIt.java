import java.sql.SQLSyntaxErrorException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TesteDriveIt {
    public static void main(String[] args) {
        Veiculo v1 = new VeiculoNormal("DE-AN-07", "Honda", "CR-V", 2015, 60,
                2, new ArrayList<Integer>(Arrays.asList(10)),10);
        Veiculo v2 = new VeiculoPremium("20-JA-VA", "Toyota", "Prius", 2018, 55,
                1.5, new ArrayList<Integer>(Arrays.asList(8, 5, 9)), 82, 2,3);

        Map<String, Veiculo> veiculos = Stream.of(v1,v2).collect(Collectors.toMap(Veiculo::getId, Veiculo::clone));
        DriveIt driveIt = new DriveIt(veiculos);

        Veiculo v3 = new AutocarroInteligente("13-37-XD", "Toyota", "Yaris", 2000, 58,
                1.8, new ArrayList<Integer>(Arrays.asList(4, 6, 2, 5)),200, 40, 5);
        Veiculo v4 = new VeiculoOcasiao("AB-CD-01", "Opel", "Corsa", 2008, 70,
                2.5, new ArrayList<Integer>(),3);

        try {driveIt.adiciona(new HashSet<>(Arrays.asList(v3, v4)));}
        catch (VeiculoAlreadyPresentException e) {e.printStackTrace();}

        Veiculo v5 = new VeiculoOcasiao("67-YZ-89", "Nissan", "Leaf", 2020, 50,
                2, new ArrayList<Integer>(Arrays.asList(8, 7, 9)), 37, true);
        try {driveIt.adiciona(v5);}
        catch (VeiculoAlreadyPresentException e) {e.printStackTrace();}

        System.out.println("Teste existeVeiculo: " + (driveIt.existeVeiculo("AB-CD-01") && !driveIt.existeVeiculo("EF-GH-IJ") ? "Passou" : "Não passou"));
        System.out.println("Teste quantos: " + (driveIt.quantos() == 5 ? "Passou" : "Não passou"));
        System.out.println("Teste quantos(String marca): " + (driveIt.quantos("Toyota") == 2 && driveIt.quantos("Volkswagen") == 0 ? "Passou" : "Não passou"));
        try {System.out.println("Teste getVeiculo: " + (driveIt.getVeiculo("DE-AN-07").equals(v1) ? "Passou" : "Não passou"));}
        catch (VeiculoNotFoundException e) {e.printStackTrace();}

        System.out.println("Teste getVeiculos: " + (driveIt.getVeiculos().containsAll(Arrays.asList(v1,v2,v3,v4,v5)) &&
                Arrays.asList(v1,v2,v3,v4,v5).containsAll(driveIt.getVeiculos()) ? "Passou" : "Não passou"));
        try {
            driveIt.registarAluguer("DE-AN-07",42);
        } catch (InvalidValueException | VeiculoNotFoundException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Teste registarAluguer: " + (Double.compare(driveIt.getVeiculo("DE-AN-07").getKmsUltimo(), 42.0) == 0 ? "Passou" : "Não Passou"));
        } catch (VeiculoNotFoundException e) {
            e.printStackTrace();
        }
        try {
            driveIt.classificarVeiculo("DE-AN-07",9);
        } catch (InvalidValueException | VeiculoNotFoundException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Teste classificarVeiculo: " + (Math.abs(Double.compare(driveIt.getVeiculo("DE-AN-07").getClassificacao(), 9.5)) < 0.1 ? "Passou" : "Não passou"));
        } catch (VeiculoNotFoundException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Teste custoRealKm: " + (Math.abs(Double.compare(driveIt.custoRealKm("DE-AN-07"),114.4)) < 0.1 ? "Passou" : "Não passou"));
        } catch (VeiculoNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Teste quantosT: " + (driveIt.quantosT("VeiculoOcasiao") == 2 && driveIt.quantosT("VeiculoPremium") == 1 ?"Passou":"Não passou"));

        List<Veiculo> veiculosOrdenadosCusto = driveIt.veiculosOrdenadosCusto();
        veiculosOrdenadosCusto.sort(Comparator.comparingDouble(Veiculo::getCustoPorKm).reversed());
        System.out.println("Teste veiculosOrdenadosCusto: " + (veiculosOrdenadosCusto.equals(driveIt.veiculosOrdenadosCusto()) ? "Passou" : "Não passou"));

        try {
            System.out.println("Teste veiculoMaisBarato: " + (driveIt.veiculoMaisBarato().getId().equals(v4.getId()) ? "Passou" : "Não passou"));
        } catch (VeiculoNotFoundException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Teste veiculoMenosUtilizado: " + (driveIt.veiculoMenosUtilizado().getId().equals(v4.getId()) ? "Passou" : "Não passou"));
        } catch (VeiculoNotFoundException e) {
            e.printStackTrace();
        }

        List<Veiculo> ordenados = new ArrayList<>(driveIt.ordenarVeiculosSet());
        System.out.println("Teste ordenarVeiculos 1: " + (ordenados.equals(driveIt.ordenarVeiculosList()) && driveIt.ordenarVeiculosList().equals(driveIt.ordenarVeiculosList().stream().sorted().collect(Collectors.toList()))?"Passou":"Não passou"));
        System.out.println("Teste ordenarVeiculos 2: " + (driveIt.ordenarVeiculos(Comparator.comparing(Veiculo::getModelo)).equals(new TreeSet<>(Arrays.asList(v4,v1,v5,v2,v3)))?"Passou":"Não passou"));

        DriveIt.addComparador("Classificação média reversa", Comparator.comparingDouble(Veiculo::getClassificacao).reversed());
        Iterator<Veiculo> iterador = driveIt.ordenarVeiculo("Classificação média reversa");
        System.out.println("Teste ordenarVeiculos 3: " + (iterador.next().getId().equals(v1.getId()) && iterador.next().getId().equals(v5.getId()) ? "Passou" : "Não passou"));

        System.out.println("Teste daoPontos: " + (driveIt.daoPontos().containsAll(Arrays.asList(v2,v3)) && Arrays.asList(v2,v3).containsAll(driveIt.daoPontos()) ? "Passou" : "Não passou"));

        driveIt.exportToFile("driveIt.csv");

        DriveIt driveIt2 = new DriveIt();

        String outputFile = driveIt.saveState();
        driveIt2.loadState(outputFile);

        System.out.println("Teste serialization: " + (driveIt.equals(driveIt2) ? "Passou" : "Não passou"));

        try {
            System.out.print("Teste exceptions: ");
            driveIt.adiciona(v1);
            System.out.println("Não passou");
        }
        catch (VeiculoAlreadyPresentException e) {
            try {
                driveIt.classificarVeiculo("DE-AN-07", 21);
                System.out.println("Não passou");
            }
            catch (InvalidValueException | VeiculoNotFoundException exception) {
                try {
                    driveIt.getVeiculo("PC-DI-64");
                    System.out.println("Não passou");
                } catch (VeiculoNotFoundException veiculoNotFoundException) {
                    System.out.println("Passou");
                }
            }
        }
    }
}
