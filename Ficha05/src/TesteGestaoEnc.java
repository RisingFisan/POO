import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class TesteGestaoEnc {
    public static void main(String[] args) {
        Encomenda encomenda1 = new Encomenda("1", "Sofia", 123456789, "Rua da Liberdade", 31, LocalDate.now(), new ArrayList<LinhaEncomenda>());
        System.out.println("Encomenda criada: " + encomenda1.toString());

        LinhaEncomenda linha1 = new LinhaEncomenda("13579", "Produto 1", 10, 5, 100, 20);
        encomenda1.adicionaLinha(linha1); // 5 (10 + 10 - 2) = 90
        System.out.println("Inserida linha de encomenda: " + linha1.toString());
        LinhaEncomenda linha2 = new LinhaEncomenda("24680", "Produto 2", 16, 8, 25, 12.5);
        encomenda1.adicionaLinha(linha2); // 8 (16 + 4 - 2) = 144
        System.out.println("Inserida linha de encomenda: " + linha2.toString());

        Encomenda encomenda2 = new Encomenda("2", "Rita", 987654321, "Avenida Central", 7, LocalDate.of(2018,5,21), new ArrayList<LinhaEncomenda>());
        System.out.println("Encomenda criada: " + encomenda2.toString());

        LinhaEncomenda linha3 = new LinhaEncomenda("12345", "Produto 3", 10, 5, 100, 20);
        encomenda2.adicionaLinha(linha3); // 5 (10 + 10 - 2) = 90
        System.out.println("Inserida linha de encomenda: " + linha3.toString());
        LinhaEncomenda linha4 = new LinhaEncomenda("67890", "Produto 4", 16, 8, 25, 12.5);
        encomenda2.adicionaLinha(linha4); // 8 (16 + 4 - 2) = 144
        System.out.println("Inserida linha de encomenda: " + linha4.toString());
        LinhaEncomenda linha5 = new LinhaEncomenda("01134", "Produto 5", 16, 8, 25, 12.5);
        encomenda2.adicionaLinha(linha5); // 8 (16 + 4 - 2) = 144
        System.out.println("Inserida linha de encomenda: " + linha5.toString());

        TreeMap<String, Encomenda> mapEnc = new TreeMap<>();
        mapEnc.put(encomenda1.getIdEnc(), encomenda1);
        mapEnc.put(encomenda2.getIdEnc(), encomenda2);
        GestaoEncomendas gestaoEncomendas = new GestaoEncomendas(mapEnc);

        Encomenda encomenda3 = new Encomenda("3", "Jorge", 135792468, "Largo do Poço", 13, LocalDate.of(2019,12,24), new ArrayList<LinhaEncomenda>());
        System.out.println("Encomenda criada: " + encomenda3.toString());

        LinhaEncomenda linha6 = new LinhaEncomenda("12345", "Produto 6", 10, 5, 100, 20);
        encomenda3.adicionaLinha(linha6); // 5 (10 + 10 - 2) = 90
        System.out.println("Inserida linha de encomenda: " + linha6.toString());

        gestaoEncomendas.addEncomenda(encomenda3);

        Set<String> codsEnc = gestaoEncomendas.todosCodigosEnc();
        System.out.println("Teste função todosCodigosEnc: " + codsEnc.toString() + '\n');

        System.out.println("Teste função getEncomenda (3): " + gestaoEncomendas.getEncomenda("3").toString() + '\n');

        System.out.println("Teste função encomendaComMaisProdutos (2): " + gestaoEncomendas.encomendaComMaisProdutos().toString() + '\n');

        System.out.println("Teste função encomendasComProduto (2 e 3): " + gestaoEncomendas.encomendasComProduto("12345") + '\n');

        System.out.println("Teste função encomendasAposData (1): " + gestaoEncomendas.encomendasAposData(LocalDate.of(2020,1,1)));

        List<Encomenda> encsDecresc = gestaoEncomendas.encomendasValorDescrescente();
        System.out.println("Teste função encomendasValorDecrescente: " + encsDecresc.toString() + '\n');

        Map<String, List<String>> encomendasProds = gestaoEncomendas.encomendasDeProduto();
        System.out.println("Teste função encomendasDeProduto: " + encomendasProds.toString() + '\n');

        gestaoEncomendas.removeEncomenda("3");
        System.out.println("Teste função removeEncomenda: " + (gestaoEncomendas.getEncomenda("3") == null ? "passou" : "não passou") + '\n');
    }
}
