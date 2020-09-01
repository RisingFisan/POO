/**
 * Classe que implementa uma linha de encomenda.
 *
 * @author Sofia Santos
 */

public class LinhaEncomenda {

    //variáveis de instância
    private String referencia;
    private String descricao;
    private double precoSemTaxas;
    private int quantidade;
    private double imposto;
    private double descontoComercial;

    /**
     * Construtores da classe LinhaEncomenda
     * Declaração dos construtores por omissão (vazio),
     * parametrizado e de cópia.
     */

    /**
     * Construtor por omissão de LinhaEncomenda.
     */

    public LinhaEncomenda() {
        this.referencia = "";
        this.descricao = "";
        this.precoSemTaxas = 0;
        this.quantidade = 0;
        this.imposto = 0;
        this.descontoComercial = 0;
    }

    /**
     * Construtor parametrizado de LinhaEncomenda.
     * @param referencia a referência do produto
     * @param descricao a descrição do produto
     * @param precoSemTaxas o preço do produto antes de impostos
     * @param quantidade a quantidade encomendada
     * @param imposto o regime de imposto que se aplica ao produto, em percentagem
     * @param descontoComercial o valor, em percentagem, do desconto comercial em relação ao preço antes de impostos
     */

    public LinhaEncomenda(String referencia, String descricao, double precoSemTaxas, int quantidade, double imposto, double descontoComercial) {
        this.referencia = referencia;
        this.descricao = descricao;
        this.precoSemTaxas = precoSemTaxas;
        this.quantidade = quantidade;
        this.imposto = imposto;
        this.descontoComercial = descontoComercial;
    }

    /**
     * Construtor de cópia de LinhaEncomenda.
     * @param linha a linha de encomenda original, que se pretende copiar
     */

    public LinhaEncomenda(LinhaEncomenda linha) {
        this.referencia = linha.getReferencia();
        this.descricao = linha.getDescricao();
        this.precoSemTaxas = linha.getPrecoSemTaxas();
        this.quantidade = linha.getQuantidade();
        this.imposto = linha.getImposto();
        this.descontoComercial = linha.getDescontoComercial();
    }

    public String getReferencia() {
        return this.referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoSemTaxas() {
        return this.precoSemTaxas;
    }

    public void setPrecoSemTaxas(double precoSemTaxas) {
        this.precoSemTaxas = precoSemTaxas;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getImposto() {
        return this.imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public double getDescontoComercial() {
        return this.descontoComercial;
    }

    public void setDescontoComercial(double descontoComercial) {
        this.descontoComercial = descontoComercial;
    }

    /**
     * Método que calcula o valor final da venda, já tendo em conta os impostos e os descontos.
     * @return preço final a pagar
     */

    public double calculaValorLinhaEnc() {
        return (1 + (this.imposto - this.descontoComercial)/100)*this.precoSemTaxas;
    }

    /**
     * Método que calcula o valor que deverá ser descontado do preço antes de impostos.
     * @return valor do desconto.
     */

    public double calculaValorDesconto() {
        return this.descontoComercial/100 * this.precoSemTaxas;
    }

    /**
     * Método que devolve a representação em String da linha de encomenda.
     * @return String com os parâmetros da linha de encomenda.
     */

    public String toString() {
        final StringBuffer sb = new StringBuffer("Linha de Encomenda {\n");
        sb.append("\treferência='").append(referencia).append("',\n");
        sb.append("\tdescrição='").append(descricao).append("',\n");
        sb.append("\tpreco antes de impostos=").append(precoSemTaxas).append(",\n");
        sb.append("\tquantidade encomendada=").append(quantidade).append(",\n");
        sb.append("\timposto=").append(String.format("%.2f%%",imposto)).append(",\n");
        sb.append("\tdescontoComercial=").append(String.format("%.2f%%",descontoComercial)).append(",\n");
        sb.append('}');
        return sb.toString();
    }

    /**
     * Método que determina se duas linhas de encomenda são iguais.
     * @param o objeto que se quer determinar se é igual ou não a outro objeto
     * @return bool que é verdadeiro se os dois objetos forem iguais, falso se não forem.
     */

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        LinhaEncomenda that = (LinhaEncomenda) o;
        return Double.compare(that.precoSemTaxas, this.precoSemTaxas) == 0 &&
                this.quantidade == that.quantidade &&
                Double.compare(that.imposto, this.imposto) == 0 &&
                Double.compare(that.descontoComercial, this.descontoComercial) == 0 &&
                this.referencia.equals(that.referencia) &&
                this.descricao.equals(that.descricao);
    }

    /**
     * Método que faz uma cópia do objeto recetor da mensagem.
     * Para tal invoca o construtor de cópia.
     *
     * @return objeto clone do objeto que recebe a mensagem.
     */

    public LinhaEncomenda clone() {
        return new LinhaEncomenda(this);
    }
}
