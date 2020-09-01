import java.util.List;

public class VeiculoNormal extends Veiculo{
    public VeiculoNormal() {
        super();
    }

    public VeiculoNormal(String id, String marca, String modelo, int ano, double velMediaPorKm, double precoTeoricoPorKm, List<Integer> classificacoes) {
        super(id, marca, modelo, ano, velMediaPorKm, precoTeoricoPorKm, classificacoes);
    }

    public VeiculoNormal(String id, String marca, String modelo, int ano, double velMediaPorKm,
                         double precoTeoricoPorKm, List<Integer> classificacoes, double kms) {
        super(id, marca, modelo, ano, velMediaPorKm, precoTeoricoPorKm, classificacoes, kms);
    }

    public VeiculoNormal(String id, String marca, String modelo, int ano, double velMediaPorKm,
                         double precoTeoricoPorKm, List<Integer> classificacoes, double kms, double kmsUltimo) {
        super(id, marca, modelo, ano, velMediaPorKm, precoTeoricoPorKm, classificacoes, kms, kmsUltimo);
    }

    public VeiculoNormal(VeiculoNormal veiculo) {
        super(veiculo);
    }

    public double getCustoPorKm() {
        return custoPorKm();
    }

    public VeiculoNormal clone() {
        return new VeiculoNormal(this);
    }

    public String toString() {
        String sb = "Veículo Normal {\n" + super.toString() +
                "}";
        return sb;
    }
}
