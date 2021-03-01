package poo;

public class Cliente {
    
    private String documento;
    private String descricao;
    private String dataOperacao;
    private double valor;

    public Cliente(String documento, String descricao, String dataOperacao, double valor) {
        this.documento = documento;
        this.descricao = descricao;
        this.dataOperacao = dataOperacao;
        this.valor = valor;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(String dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "\n\nData da Operacao = " + dataOperacao + "\nDescricao = " + descricao + 
            "\nDocumento = " + documento+ "\nValor = " + valor + " R$\n\n";
    }

}
