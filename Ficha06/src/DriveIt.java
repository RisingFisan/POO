import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DriveIt implements Serializable {
    private static final Map<String, Comparator<Veiculo>> comparadores = new HashMap<>();

    public static Comparator<Veiculo> getComparador(String criterio) {
        return comparadores.get(criterio);
    }

    public static void addComparador(String criterio, Comparator<Veiculo> comparador) {
        comparadores.put(criterio, comparador);
    }

    private Map<String,Veiculo> veiculosMap;
    private boolean epocaDesconto;

    public DriveIt() {
        this.veiculosMap = new HashMap<>();
    }

    public DriveIt(Map<String,Veiculo> veiculos) {
        this.setVeiculosMap(veiculos);
        this.epocaDesconto = false;
    }

    public DriveIt(DriveIt driveIt) {
        this.veiculosMap = driveIt.getVeiculosMap();
        this.epocaDesconto = driveIt.epocaDesconto;
    }

    public boolean isEpocaDesconto() {
        return this.epocaDesconto;
    }

    public void setVeiculosMap(Map<String,Veiculo> veiculos) {
        this.veiculosMap = veiculos.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e-> e.getValue().clone()));
    }

    public Map<String,Veiculo> getVeiculosMap() {
        return this.veiculosMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));
    }

    public boolean existeVeiculo(String cod) {
        return this.veiculosMap.keySet().stream()
                .anyMatch(c -> c.equals(cod));
    }

    public int quantos() {
        return this.veiculosMap.size();
    }

    public int quantos(String marca) {
        return (int) this.veiculosMap.values().stream()
                .filter(v -> v.getMarca().equals(marca)).count();
    }

    public Veiculo getVeiculo(String cod) throws VeiculoNotFoundException {
        Veiculo v = this.veiculosMap.get(cod);
        if(v == null) throw new VeiculoNotFoundException("Veículo " + cod + " não existe!");
        else return v.clone();
    }

    public void adiciona(Veiculo v) throws VeiculoAlreadyPresentException {
        if(this.veiculosMap.containsKey(v.getId())) throw new VeiculoAlreadyPresentException("Veículo " + v.getId() + " já existe na base de dados!");
        else this.veiculosMap.put(v.getId(), v.clone());
    }

    public List<Veiculo> getVeiculos() {
        return new ArrayList<>(this.veiculosMap.values());
    }

    public void adiciona(Set<Veiculo> vs) throws VeiculoAlreadyPresentException {
        for (Veiculo v : vs) {
            adiciona(v.clone());
        }
    }

    public void registarAluguer(String codVeiculo, int numKms) throws InvalidValueException, VeiculoNotFoundException {
        if(numKms < 0) throw new InvalidValueException(String.valueOf(numKms) + " tem que ser um valor positivo.");
        if(!this.veiculosMap.containsKey(codVeiculo)) throw new VeiculoNotFoundException("Veículo " + codVeiculo + " não encontrado.");
        Veiculo v = this.veiculosMap.get(codVeiculo);
        v.addKms(numKms);
    }

    public void classificarVeiculo(String cod, int classificacao) throws InvalidValueException, VeiculoNotFoundException {
        if(classificacao < 0 || classificacao > 10) throw new InvalidValueException(String.valueOf(classificacao) + " tem que ser um valor entre 0 e 10!");
        if(!this.veiculosMap.containsKey(cod)) throw new VeiculoNotFoundException("Veículo " + cod + " não encontrado.");
        Veiculo v = this.veiculosMap.get(cod);
        v.addClassificacao(classificacao);
    }

    public double custoRealKm(String cod) throws VeiculoNotFoundException {
        if(!this.veiculosMap.containsKey(cod)) throw new VeiculoNotFoundException("Veículo " + cod + " não existe!");
        return this.veiculosMap.get(cod).getCustoPorKm();
    }




    public void alterarPromocao(boolean estado) {
        this.epocaDesconto = estado;
        this.veiculosMap.values().stream().filter(v -> v instanceof VeiculoOcasiao).forEach(v -> ((VeiculoOcasiao)v).setEmDesconto(estado));
    }


    public int quantosT(String tipo) {
        return (int) this.veiculosMap.values().stream().filter(v -> v.getClass().toString().split(" ")[1].equals(tipo)).count();
    }

    public List<Veiculo> veiculosOrdenadosCusto() {
        return this.veiculosMap.values().stream()
                .sorted(Comparator.comparingDouble(Veiculo::getCustoPorKm).reversed())
                .collect(Collectors.toList());
    }

    public Veiculo veiculoMaisBarato() throws VeiculoNotFoundException {
        if(this.veiculosMap.size() == 0) throw new VeiculoNotFoundException("Não existem veículos na base de dados!");
        List<Veiculo> vs = this.veiculosOrdenadosCusto();
        return vs.get(vs.size() - 1);
    }

    public Veiculo veiculoMenosUtilizado() throws VeiculoNotFoundException{
        if(this.veiculosMap.size() == 0) throw new VeiculoNotFoundException("Não existem veículos na base de dados!");
        return this.veiculosMap.values().stream()
                .min(Comparator.comparingDouble(Veiculo::getKms))
                .orElse(null);
    }




    public Set<Veiculo> ordenarVeiculosSet() {
        return this.veiculosMap.values().stream()
                .map(Veiculo::clone)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public List<Veiculo> ordenarVeiculosList() {
        return this.veiculosMap.values().stream()
                .sorted()
                .map(Veiculo::clone)
                .collect(Collectors.toList());
    }

    public Set<Veiculo> ordenarVeiculos(Comparator<Veiculo> c) {
        return this.veiculosMap.values().stream()
                .sorted(c)
                .map(Veiculo::clone)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public Iterator<Veiculo> ordenarVeiculo(String criterio) {
        Comparator<Veiculo> comparator = comparadores.get(criterio);
        if(comparator == null) return null;
        return this.veiculosMap.values().stream()
                .sorted(comparator)
                .iterator();
    }


    public List<BonificaKms> daoPontos() {
        return this.veiculosMap.values().stream()
                .filter(v -> v instanceof BonificaKms)
                .map(v -> (BonificaKms)v.clone())
                .collect(Collectors.toList());
    }



    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriveIt driveIt = (DriveIt) o;
        return Objects.equals(veiculosMap, driveIt.veiculosMap);
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer("DriveIt {\n");
        sb.append("Veículos ").append(veiculosMap).append('\n');
        sb.append("\n}");
        return sb.toString();
    }

    public DriveIt clone() {
        return new DriveIt(this);
    }

    public void exportToFile(String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for(Veiculo v : this.veiculosMap.values()) {
                writer.write(v.toString() + ",\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String saveState() {
        String outputFile = "./driveIt.ser";
        try {
            FileOutputStream fos = new FileOutputStream(outputFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            fos.close();
            return outputFile;
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void loadState(String inputFile) {
        try {
            FileInputStream fis = new FileInputStream(inputFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            DriveIt copy = (DriveIt) ois.readObject();
            this.setVeiculosMap(copy.getVeiculosMap());
            this.epocaDesconto = copy.epocaDesconto;
            ois.close();
            fis.close();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
