import java.util.List;

public class AutocarroInteligente extends Veiculo implements BonificaKms {
    private int lotacao;
    private int ocupacao;
    private int pontosPorKm;

    public AutocarroInteligente() {
        super();
        this.lotacao = 0;
        this.ocupacao = 0;
        this.pontosPorKm = 0;
    }

    public AutocarroInteligente(String id, String marca, String modelo, int ano, double velMediaPorKm, double precoTeoricoPorKm, List<Integer> classificacoes, int lotacao, int pontosPorKm) {
        super(id, marca, modelo, ano, velMediaPorKm, precoTeoricoPorKm, classificacoes);
        this.lotacao = lotacao;
        this.pontosPorKm = pontosPorKm;
        this.ocupacao = 0;
    }

    public AutocarroInteligente(String id, String marca, String modelo, int ano, double velMediaPorKm,
                                double precoTeoricoPorKm, List<Integer> classificacoes, double kms, int lotacao, int pontosPorKm) {
        super(id, marca, modelo, ano, velMediaPorKm, precoTeoricoPorKm, classificacoes, kms);
        this.lotacao = lotacao;
        this.pontosPorKm = pontosPorKm;
        this.ocupacao = 0;
    }

    public AutocarroInteligente(String id, String marca, String modelo, int ano, double velMediaPorKm,
                                double precoTeoricoPorKm, List<Integer> classificacoes, double kms, double kmsUltimo, int lotacao, int pontosPorKm) {
        super(id, marca, modelo, ano, velMediaPorKm, precoTeoricoPorKm, classificacoes, kms, kmsUltimo);
        this.lotacao = lotacao;
        this.pontosPorKm = pontosPorKm;
        this.ocupacao = 0;
    }

    public AutocarroInteligente(AutocarroInteligente v) {
        super(v);
        this.lotacao = v.lotacao;
        this.ocupacao = v.ocupacao;
        this.pontosPorKm = v.pontosPorKm;
    }

    public int getLotacao() {
        return this.lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    public int getOcupacao() {
        return this.ocupacao;
    }

    public void setOcupacao(int ocupacao) {
        this.ocupacao = ocupacao;
    }

    public double getCustoPorKm() {
        double ratio = ocupacao / lotacao;
        if(ratio <= 0.6) return custoPorKm() * 0.5;
        else return custoPorKm() * 0.25;
    }

    public AutocarroInteligente clone() {
        return new AutocarroInteligente(this);
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer("Autocarro Inteligente {\n");
        sb.append(super.toString());
        sb.append("\tLotação = ").append(lotacao).append('\n');
        sb.append("\tOcupação = ").append(ocupacao).append('\n');
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
