package gerenciamento_estoque;

import java.util.Scanner;

public class Prod_Medicamento extends Produto {
    
    Scanner input = new Scanner(System.in);
    
    @Override
    public Prod_Medicamento cadastrarProduto(String idProd){//Este cadastro é exclusivo para produtos que são medicamentos
        
        Prod_Medicamento prod = new Prod_Medicamento();
        
        prod.setIdProd(idProd);
        
        System.out.println("\n>>>>>>>>>> CADASTRAR PRODUTO <<<<<<<<<<<");
        
        System.out.print("Nome: ");
        prod.setNome(input.nextLine());
        
        System.out.print("Marca: ");
        prod.setMarca(input.nextLine());
        
        System.out.print("Descrição: ");
        prod.setDescricao(input.nextLine());
        
        System.out.print("Bula: ");
        prod.setBula(input.nextLine());
        
        System.out.print("Receita nescessária? ('sim'/qualquer texto para não): ");
        prod.setReceitaNecessaria("sim".equals(input.nextLine()));
        
        try{
            System.out.print("Preço: R$ ");
            prod.setPreco(Double.parseDouble(input.nextLine()));            
        }catch(NumberFormatException e){
            System.out.println(">> Erro! preço deve ser um valor numérico. Edite este produto para corrigir. <<");
        }
        
        try{
            System.out.print("Quantidade: ");
            prod.setQuantidade(Integer.parseInt(input.nextLine()));    
        }catch(NumberFormatException e){
            System.out.println(">> Erro! quantidade deve ser um valor numérico. Edite este produto para corrigir. <<");
        }
        
        System.out.println(">> Produto cadastrado com sucesso! <<\n");
        
        return prod;
    }
}
