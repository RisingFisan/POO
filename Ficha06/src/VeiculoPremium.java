import java.util.List;

public class VeiculoPremium extends Veiculo implements BonificaKms{
    private double taxaDeLuxo;
    private int pontosPorKm;

    public VeiculoPremium() {
        super();
        this.taxaDeLuxo = 0;
        this.pontosPorKm = 0;
    }

    public VeiculoPremium(String id, String marca, String modelo, int ano, double velMediaPorKm, double precoTeoricoPorKm, List<Integer> classificacoes, double taxaDeLuxo, int pontosPorKm) {
        super(id, marca, modelo, ano, velMediaPorKm, precoTeoricoPorKm, classificacoes);
        this.taxaDeLuxo = taxaDeLuxo;
        this.pontosPorKm = pontosPorKm;
    }

    public VeiculoPremium(String id, String marca, String modelo, int ano, double velMediaPorKm,
                          double precoTeoricoPorKm, List<Integer> classificacoes, double kms, double taxaDeLuxo, int pontosPorKm) {
        super(id, marca, modelo, ano, velMediaPorKm, precoTeoricoPorKm, classificacoes, kms);
        this.taxaDeLuxo = taxaDeLuxo;
        this.pontosPorKm = pontosPorKm;
    }

    public VeiculoPremium(String id, String marca, String modelo, int ano, double velMediaPorKm,
                          double precoTeoricoPorKm, List<Integer> classificacoes, double kms, double kmsUltimo, double taxaDeLuxo, int pontosPorKm) {
        super(id, marca, modelo, ano, velMediaPorKm, precoTeoricoPorKm, classificacoes, kms, kmsUltimo);
        this.taxaDeLuxo = taxaDeLuxo;
        this.pontosPorKm = pontosPorKm;
    }

    public VeiculoPremium(VeiculoPremium v) {
        super(v);
        this.taxaDeLuxo = v.taxaDeLuxo;
        this.pontosPorKm = v.pontosPorKm;
    }

    public double getTaxaDeLuxo() {
        return this.taxaDeLuxo;
    }

    public void setTaxaDeLuxo(double taxaDeLuxo) {
        this.taxaDeLuxo = taxaDeLuxo;
    }

    public double getCustoPorKm() {
        return custoPorKm() * this.taxaDeLuxo;
    }

    public VeiculoPremium clone() {
        return new VeiculoPremium(this);
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer("Veículo Premium {\n");
        sb.append(super.toString());
        sb.append("\tTaxa De Luxo = ").append(taxaDeLuxo).append('\n');
        sb.append("\tPontos Por Km = ").append(pontosPorKm).append('\n');
        sb.append("}");
        return sb.toString();
    }

    public void setPontosPorKm(int pontosPorKm) {
        this.pontosPorKm = pontosPorKm;
    }

    public int getPontosPorKm() {
        return this.pontosPorKm;
    }
}
