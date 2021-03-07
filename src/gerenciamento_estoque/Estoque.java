package gerenciamento_estoque;

import java.util.ArrayList;
import java.util.Scanner;
import farmacia.Farmacia;

public class Estoque implements Farmacia{
    
    private int ContID; //esta variável é um contador para automatizar identificação dos produtos
    ArrayList<Produto> Produtos = new ArrayList<>();

    public ArrayList<Produto> getProdutos() {
        return Produtos;
    }

    public void setProdutos(ArrayList<Produto> Produtos) {
        this.Produtos = Produtos;
    }
    
    Scanner input = new Scanner(System.in);
    
    @Override
    public void inserir(){//Adiciona um produto no estoque
        
        System.out.println("\n>>>>>>>>>> ADICIONAR PRODUTO <<<<<<<<<<<");
        System.out.println("-> Digite 1 para adicionar um medicamento");
        System.out.println("-> Digite 2 para adicionar outro tipo de produto");
        System.out.println("-> Digite 0 para voltar");
        System.out.println("________________________________________");
        
        switch(input.nextLine()){
            case "1": Prod_Medicamento prod1 = new Prod_Medicamento();
                    ContID++;
                    this.Produtos.add(prod1.cadastrarProduto(Integer.toString(ContID)));
                    break;
            case "2": Prod_Variedades prod2 = new Prod_Variedades();
                    ContID++;
                    this.Produtos.add(prod2.cadastrarProduto(Integer.toString(ContID)));
                    break;
            case "0": break;
            default: System.out.println(">> Opção inválida! <<\n");
                    break;
            
        }
    }
    
    @Override
    public boolean verificar(String idProd){ // verifica se o produto está cadastrado
        for(int i = 0; i < Produtos.size(); i++){
            if(idProd.equals(Produtos.get(i).getIdProd())){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void editar(){ // edita os dados do produto
        System.out.println("\n>>>>>>>>>> EDITAR PRODUTO <<<<<<<<<<");
        System.out.print("Digite o ID do produto: ");
        String idProd = input.nextLine();
        if(verificar(idProd)){ // Só permite editar os produtos que estão cadastrados
            for(int i = 0; i < Produtos.size(); i++){
                if(idProd.equals(Produtos.get(i).getIdProd())){
                    System.out.println("| Nome do produto: " + Produtos.get(i).getNome());
                    System.out.println("| Marca: " + Produtos.get(i).getMarca());
                    System.out.println("| Descrição: " + Produtos.get(i).getDescricao());
                    System.out.println("| Preço: R$ " + Produtos.get(i).getPreco());
                    System.out.println("| Quantidade disponível: " + Produtos.get(i).getQuantidade());
                    System.out.println("________________________________________");

                    
                    System.out.println("(Para não alterar o dado basta deixar o campo vazio)");
                    
                    System.out.print("Novo nome: ");
                    String novo_nome = input.nextLine();
                    if(!"".equals(novo_nome))
                        Produtos.get(i).setNome(novo_nome);
                    
                    System.out.print("Nova marca: ");
                    String nova_marca = input.nextLine();
                    if(!"".equals(nova_marca))
                        Produtos.get(i).setMarca(nova_marca);
                    
                    System.out.print("Nova descrição: ");
                    String nova_descricao = input.nextLine();
                    if(!"".equals(nova_descricao))
                        Produtos.get(i).setDescricao(nova_descricao);
                    
                    try{
                        System.out.print("Novo preço: ");
                        double novo_preco = Double.parseDouble(input.nextLine());
                        if(!"".equals(novo_preco))
                            Produtos.get(i).setPreco(novo_preco);
                    }catch(NumberFormatException e){}
                    
                    try{
                        System.out.print("Nova quantidade: ");
                        int nova_quantidade = Integer.parseInt(input.nextLine());
                        if(!"".equals(nova_quantidade))
                            Produtos.get(i).setQuantidade(nova_quantidade);
                        }catch(NumberFormatException e){}
                }
            }
            System.out.println(">> Produto editado com sucesso! <<\n");
        }else{
            System.out.println(">> Impossível editar! Pois o produto é inexistente no estoque. <<\n");
        }
        
    }
    
    @Override
    public void remover(){ // remove um produto do estoque
        System.out.println("\n>>>>>>>>>> REMOVER PRODUTO <<<<<<<<<<");
        
        System.out.print("Digite o ID do produto: ");
        String idProd = input.nextLine();
        
        if(verificar(idProd)){ // só pode remover se o produto estiver cadastrado
            for(int i = 0; i < Produtos.size(); i++){
                if(idProd.equals(Produtos.get(i).getIdProd())){
                    Produtos.remove(i);
                }
            }
            System.out.println(">> Produto removido com sucesso! <<\n");
        }else{
            System.out.println(">> Impossível remover! Pois o produto é inexistente no estoque. <<\n");
        }
        
    }
    
    @Override
    public void exibir() { // lista todos os produtos cadastrados
        System.out.println("\n>>>>>>>>>> EXIBINDO ESTOQUE <<<<<<<<<<");
        for(Produto p: this.Produtos){
            System.out.println("| ID: " + p.getIdProd());
            System.out.println("| Produto: " + p.getNome());
            System.out.println("| Marca: " + p.getMarca());
            System.out.println("| Preço: R$ " + p.getPreco());
            System.out.println("| Quantidade disponível: " + p.getQuantidade());
            System.out.println("________________________________________");
        }
    }
}