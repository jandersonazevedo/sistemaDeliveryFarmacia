package farmacia;
//Esta interface é implementada nas classes Cliente e Estoque
public interface Farmacia {
    public void inserir();
    public void editar();
    public void remover();
    public boolean verificar(String id);
    public void exibir();
}
