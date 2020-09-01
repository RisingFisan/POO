import java.time.LocalDate;
import java.util.ArrayList;

public class Encomenda {
    private String idEnc;
    private String nomeCliente;
    private int nif;
    private String morada;
    private int nEnc;
    private LocalDate data;
    private ArrayList<LinhaEncomenda> encomendas;

    public Encomenda() {
        this.idEnc = null;
        this.nomeCliente = null;
        this.nif = -1;
        this.morada = null;
        this.nEnc = -1;
        this.data = LocalDate.now();
        this.encomendas = new ArrayList<LinhaEncomenda>();
    }

    public Encomenda(String idEnc, String nomeCliente, int nif, String morada, int nEnc, LocalDate data, ArrayList<LinhaEncomenda> encomendas) {
        this.nomeCliente = nomeCliente;
        this.nif = nif;
        this.morada = morada;
        this.nEnc = nEnc;
        this.data = data;
        this.idEnc = idEnc;
        this.setEncomendas(encomendas);
    }

    public Encomenda(Encomenda encomenda) {
        this.idEnc = encomenda.getIdEnc();
        this.nomeCliente = encomenda.getNomeCliente();
        this.nif = encomenda.getNif();
        this.morada = encomenda.getMorada();
        this.nEnc = encomenda.getnEnc();
        this.data = encomenda.getData();
        this.setEncomendas(encomenda.getEncomendas());
    }

    public String getIdEnc() { return this.idEnc; }

    public void setIdEnc(String idEnc) { this.idEnc = idEnc; }

    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getNif() {
        return this.nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getMorada() {
        return this.morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getnEnc() {
        return this.nEnc;
    }

    public void setnEnc(int nEnc) {
        this.nEnc = nEnc;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public ArrayList<LinhaEncomenda> getEncomendas() {
        return this.encomendas;
    }

    public void setEncomendas(ArrayList<LinhaEncomenda> encomendas) {
        this.encomendas = new ArrayList<>();
        for(LinhaEncomenda l : encomendas) {
            this.encomendas.add(l.clone());
        }
    }

    public double calculaValorTotal() {
        double valorTotal = 0;
        for(LinhaEncomenda enc : this.encomendas) {
            valorTotal += enc.calculaValorLinhaEnc();
        }
        return valorTotal;
    }

    public double calculaValorDesconto() {
        double valorDesconto = 0;
        for(LinhaEncomenda enc : this.encomendas) {
            valorDesconto += enc.calculaValorDesconto();
        }
        return valorDesconto;
    }

    public int numeroTotalProdutos() {
        int totalProdutos = 0;
        for(LinhaEncomenda enc : this.encomendas) {
            totalProdutos += enc.getQuantidade();
        }
        return totalProdutos;
    }

    public boolean existeProdutoEncomenda(String refProduto) {
        for(LinhaEncomenda enc : this.encomendas)
            if(refProduto.equals(enc.getReferencia()))
                return true;
        return false;
    }

    public void adicionaLinha(LinhaEncomenda linha) {
        this.encomendas.add(linha);
    }

    public void removeProduto(String codProd) {
        this.encomendas.removeIf(linha -> (codProd.equals(linha.getReferencia())));
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer("Encomenda {\n");
        sb.append("\tID da encomenda = '").append(this.idEnc).append("'\n");
        sb.append("\tNome de cliente = '").append(this.nomeCliente).append("'\n");
        sb.append("\tNIF = ").append(this.nif).append('\n');
        sb.append("\tMorada = '").append(this.morada).append("'\n");
        sb.append("\tNúmero de encomenda = ").append(this.nEnc).append('\n');
        sb.append("\tData = ").append(this.data.toString()).append('\n');
        sb.append("\tEncomendas = \n").append(this.encomendas.toString()).append('\n');
        sb.append('}');
        return sb.toString();
    }

    public Encomenda clone() {
        return new Encomenda(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Encomenda that = (Encomenda) o;
        return this.nif == that.nif &&
                this.nEnc == that.nEnc &&
                this.nomeCliente.equals(that.nomeCliente) &&
                this.morada.equals(that.morada) &&
                this.data.equals(that.data) &&
                this.encomendas.equals(that.encomendas);
    }
}
