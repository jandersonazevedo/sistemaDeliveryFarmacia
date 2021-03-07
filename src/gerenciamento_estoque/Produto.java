package gerenciamento_estoque;

public class Produto {
    private String idProd;
    private String nome;
    private String marca;
    private String descricao;
    private String bula;
    private boolean receitaNecessaria;
    private double preco;
    private int quantidade;

    public String getIdProd() {
        return idProd;
    }

    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getBula() {
        return bula;
    }

    public void setBula(String bula) {
        this.bula = bula;
    }

    public boolean isReceitaNecessaria() {
        return receitaNecessaria;
    }

    public void setReceitaNecessaria(boolean receitaNecessaria) {
        this.receitaNecessaria = receitaNecessaria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public Produto cadastrarProduto(String idProd){
        Produto prod = new Produto();
        return prod;
    }
}
