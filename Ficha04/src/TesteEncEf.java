import java.time.LocalDate;
import java.util.ArrayList;

public class TesteEncEf {
    public static void main(String[] args) {
        EncEficiente encomenda = new EncEficiente("Sofia", 123456789, "Rua da Liberdade", 31, LocalDate.now(), new ArrayList<LinhaEncomenda>());
        System.out.println("Encomenda criada: " + encomenda.toString());

        LinhaEncomenda linha1 = new LinhaEncomenda("13579", "Produto 1", 10, 5, 100, 20);
        encomenda.adicionaLinha(linha1); // 5 (10 + 10 - 2) = 90
        System.out.println("Inserida linha de encomenda: " + linha1.toString());
        LinhaEncomenda linha2 = new LinhaEncomenda("24680", "Produto 2", 16, 8, 25, 12.5);
        encomenda.adicionaLinha(linha2); // 8 (16 + 4 - 2) = 144
        System.out.println("Inserida linha de encomenda: " + linha2.toString());

        double valorTotal = encomenda.calculaValorTotal();
        System.out.printf("Valor total da encomenda (valor previsto = 234) = %f\n", valorTotal);

        double valorDesconto = encomenda.calculaValorDesconto();
        System.out.printf("Valor total dos descontos (valor previsto = 26) = %f\n", valorDesconto);

        int numTotalProdutos = encomenda.numeroTotalProdutos();
        System.out.printf("Número total de produtos (valor previsto = 13) = %d\n", numTotalProdutos);

        System.out.printf("O produto '12345' vai ser encomendado (valor previsto = Não)? %s\n", encomenda.existeProdutoEncomenda("12345") ? "Sim" : "Não");
        System.out.printf("O produto '24680' vai ser encomendado (valor previsto = Sim)? %s\n", encomenda.existeProdutoEncomenda("24680") ? "Sim" : "Não");

        encomenda.removeProduto("24680");
        System.out.println("Produto '24680' removido.");

        System.out.printf("O produto '24680' vai ser encomendado (valor previsto = Não)? %s\n", encomenda.existeProdutoEncomenda("24680") ? "Sim" : "Não");
    }
}
