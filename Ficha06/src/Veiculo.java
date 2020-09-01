import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public abstract class Veiculo implements Comparable<Veiculo>, Serializable {
    private String id;
    private String marca;
    private String modelo;
    private Year ano;
    private Double velMediaPorKm;
    private Double precoTeoricoPorKm;
    private List<Integer> classificacoes;
    private double kms;
    private double kmsUltimo;

    public Veiculo() {
        this.id = null;
        this.marca = null;
        this.modelo = null;
        this.ano = null;
        this.velMediaPorKm = null;
        this.precoTeoricoPorKm = null;
        this.classificacoes = null;
        this.kms = 0;
        this.kmsUltimo = 0;
    }

    public Veiculo(String id, String marca, String modelo, int ano, double velMediaPorKm, double precoTeoricoPorKm, List<Integer> classificacoes) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = Year.of(ano);
        this.velMediaPorKm = velMediaPorKm;
        this.precoTeoricoPorKm = precoTeoricoPorKm;
        this.classificacoes = new ArrayList<>(classificacoes);
        this.kms = 0;
        this.kmsUltimo = 0;
    }

    public Veiculo(String id, String marca, String modelo, int ano, double velMediaPorKm,
                   double precoTeoricoPorKm, List<Integer> classificacoes, double kms) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = Year.of(ano);
        this.velMediaPorKm = velMediaPorKm;
        this.precoTeoricoPorKm = precoTeoricoPorKm;
        this.classificacoes = new ArrayList<>(classificacoes);
        this.kms = kms;
        this.kmsUltimo = 0;
    }

    public Veiculo(String id, String marca, String modelo, int ano, double velMediaPorKm,
                   double precoTeoricoPorKm, List<Integer> classificacoes, double kms, double kmsUltimo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = Year.of(ano);
        this.velMediaPorKm = velMediaPorKm;
        this.precoTeoricoPorKm = precoTeoricoPorKm;
        this.classificacoes = new ArrayList<>(classificacoes);
        this.kms = kms;
        this.kmsUltimo = kmsUltimo;
    }

    public Veiculo(Veiculo veiculo) {
        this.id = veiculo.id;
        this.marca = veiculo.marca;
        this.modelo = veiculo.modelo;
        this.ano = Year.of(veiculo.getAno());
        this.velMediaPorKm = veiculo.velMediaPorKm;
        this.precoTeoricoPorKm = veiculo.precoTeoricoPorKm;
        this.classificacoes = new ArrayList<>(veiculo.classificacoes);
        this.kms = veiculo.kms;
        this.kmsUltimo = veiculo.kmsUltimo;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return this.ano.getValue();
    }

    public void setAno(int ano) {
        this.ano = Year.of(ano);
    }

    public Double getVelMediaPorKm() {
        return this.velMediaPorKm;
    }

    public void setVelMediaPorKm(Double velMediaPorKm) {
        this.velMediaPorKm = velMediaPorKm;
    }

    public Double getPrecoTeoricoPorKm() {
        return this.precoTeoricoPorKm;
    }

    public void setPrecoTeoricoPorKm(Double precoTeoricoPorKm) {
        this.precoTeoricoPorKm = precoTeoricoPorKm;
    }

    public double getKms() {
        return this.kms;
    }

    public void setKms(double kms) {
        this.kms = kms;
    }

    public double getKmsUltimo() { return this.kmsUltimo; }

    public void setKmsUltimo(double kmsUltimo) { this.kmsUltimo = kmsUltimo; }

    public List<Integer> getClassificacoes() {
        return new ArrayList<>(this.classificacoes);
    }

    public void setClassificacoes(List<Integer> classificacoes) {
        this.classificacoes = new ArrayList<>(classificacoes);
    }

    public double getClassificacao() {
        try {
            return this.classificacoes.stream()
                    .mapToInt(x -> x).average().getAsDouble();
        }
        catch (NoSuchElementException e) {
            return -1;
        }
    }

    public void addClassificacao(int classificacao) {
        this.classificacoes.add(classificacao);
    }

    public double custoPorKm() {
        return this.kms * this.precoTeoricoPorKm * 1.1;
    }
    public abstract double getCustoPorKm();

    public void addKms(double kms) {
        this.kms += kms;
        this.kmsUltimo = kms;
    }

    public abstract Veiculo clone();

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return this.id.equals(veiculo.id) &&
                this.marca.equals(veiculo.marca) &&
                this.modelo.equals(veiculo.modelo) &&
                this.ano.equals(veiculo.ano) &&
                this.velMediaPorKm.equals(veiculo.velMediaPorKm) &&
                this.precoTeoricoPorKm.equals(veiculo.precoTeoricoPorKm) &&
                this.classificacoes.equals(veiculo.classificacoes);
    }

    public int hashCode() {
        return Objects.hash(id, marca, modelo, ano, velMediaPorKm, precoTeoricoPorKm, classificacoes);
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("\tID = '").append(this.id).append("'\n");
        sb.append("\tMarca = '").append(this.marca).append("'\n");
        sb.append("\tModelo = '").append(this.modelo).append("'\n");
        sb.append("\tAno = ").append(this.ano).append('\n');
        sb.append("\tVelocidade Média Por Km = ").append(this.velMediaPorKm).append('\n');
        sb.append("\tPreço Teórico Por Km = ").append(this.precoTeoricoPorKm).append('\n');
        sb.append("\tClassificações = ").append(this.classificacoes).append('\n');
        sb.append("\tClassificação Média = ").append(this.getClassificacao()).append('\n');
        sb.append("\tKilómetros = ").append(this.kms).append("\n");
        sb.append("\tKilómetros da última viagem = ").append(this.kmsUltimo).append("\n");
        return sb.toString();
    }

    public int compareTo(Veiculo v) {
        if(this.marca.compareTo(v.marca) == 0) return this.modelo.compareTo(v.modelo);
        else return this.marca.compareTo(v.marca);
    }
}
