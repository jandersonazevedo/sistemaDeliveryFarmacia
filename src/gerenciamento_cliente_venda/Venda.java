package gerenciamento_cliente_venda;

import gerenciamento_estoque.Estoque;
import gerenciamento_estoque.Produto;
import java.util.ArrayList;
import java.util.Scanner;


public class Venda{

    private String rgCliente, dataVenda;
    private double valorTotal = 0;
    
    public String getRgCliente() {
        return rgCliente;
    }

    public void setRgCliente(String rgCliente) {
        this.rgCliente = rgCliente;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }
    

    Scanner input = new Scanner(System.in);
    
    public void realizarVenda(String rgCliente, Estoque estoque){
        
        System.out.println("-> Digite o ID dos produtos");
        System.out.println("-> Digite '0' para concluir a venda");
        System.out.println("________________________________________");
        
        String i = "1";
        int quantProd;
        while(!i.equals("0")){
            System.out.print("Produto -> ");
            i = input.nextLine();
            if(i.equals("0")){
                System.out.println("Valor Total: R$ " + this.valorTotal);
                System.out.println("\n>> Venda efetuada com sucesso <<!");
                break;
            }else if(!i.equals("0")){
                try{
                    System.out.print("Quantidade -> ");
                    quantProd = Integer.parseInt(input.nextLine());
                
                    if(estoque.verificar(i)){
                        for (Produto produto : estoque.getProdutos()) {
                            if(produto.getIdProd().equals(i)){
                                if((produto.getQuantidade()- quantProd) >= 0){
                                    produto.setQuantidade(produto.getQuantidade()- quantProd);
                                    this.valorTotal = this.valorTotal + (produto.getPreco() * quantProd); // Calculo para tirar o produto do estoque
                                    if(produto.isReceitaNecessaria()){
                                        System.out.println("RECEITA MÉDICA NESCESSÁRIA \n>> Produto: "+produto.getNome()+" | Preço: R$"+produto.getPreco()+" | Qtd Disponível: "+produto.getQuantidade()+" << Valor total: R$ "+this.valorTotal);    
                                    }else{
                                        System.out.println(">> Produto: "+produto.getNome()+" | Preço: R$"+produto.getPreco()+" | Qtd Disponível: "+produto.getQuantidade()+" << Valor total: R$ "+this.valorTotal);    
                                    }
                                }else{
                                    System.out.println(">> Quantidade em estoque está indiponível! <<");
                                }
                            }
                        }
                    }else{
                        System.out.println(">> Este produto está indiponível! <<");
                    }
                }catch(NumberFormatException e){
                    System.out.println(">> Digite valor numérico para quantidade! <<");
                }
            }            
        }
        
    }

}
