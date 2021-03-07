/*
ESTE PROJETO TEM COMO TEMA UM SISTEMA DE VENDAS DE UMA FARMÁCIA
Este projeto tem um Farmaceutico como ator principal, nele é possível adicionar, remover, editar, e listar todos os clientes e produtos. 
Além de realizar vendas de acordo com a quantidade disponível em estoque.
O usuário pode realizar tudo isso através de um menu personalizado para cada ação que deseja fazer.

Dupla:  Antonio Janderson Nascimento de Azevedo     Matrícula: 475231
        Géssyca Mayhara Sousa Moraes                Matrícula: 404051
 */
package farmacia;

import gerenciamento_estoque.Estoque;
import java.util.Scanner;
import gerenciamento_cliente_venda.Cliente;
import gerenciamento_cliente_venda.Venda;

public class Executar {
    
    public static void main(String[] args){
      
        Scanner entrada = new Scanner(System.in);
        
        Venda v = new Venda();
        Estoque e = new Estoque();
        Cliente c = new Cliente();
        
        String i = "1", j = "1";
        while(!"0".equals(i)){
            System.out.println("\n>>>>>>>>>> MENU INICIAL <<<<<<<<<<<<<<<<");
            System.out.println("1 -> Realizar venda");
            System.out.println("2 -> Gerenciar o estoque");
            System.out.println("3 -> Gerenciar clientes");
            System.out.println("0 -> Sair");
            System.out.println("________________________________________");
            System.out.print("-> ");
            i = entrada.nextLine();
            switch(i){
                case "1": System.out.println("\n>>>>>>>>>> REALIZAR VENDA <<<<<<<<<<<<<<");
                        System.out.print("RG do cliente: ");
                        c.setRg(entrada.nextLine());
                        if(c.verificar(c.getRg())){
                            v.realizarVenda(c.getRg(), e);
                        }else{
                            System.out.println(">> Ops! O cliente não está cadastrado. <<");
                        }
                        break;
                case "2": 
                    while(!"0".equals(j)){
                        System.out.println("\n>>>>>>>>>> GERENCIAR ESTOQUE <<<<<<<<<<<");
                        System.out.println("1 -> Adicionar produto");
                        System.out.println("2 -> Editar produto");
                        System.out.println("3 -> Remover produto");
                        System.out.println("4 -> Consultar estoque");
                        System.out.println("0 -> Voltar");
                        System.out.println("________________________________________");
                        j = entrada.nextLine();
                        switch(j){
                            case "1": e.inserir();
                                    break;
                            case "2": e.editar();
                                    System.out.println(">> Aperte ENTER para continuar <<");
                                    entrada.nextLine();
                                    break;
                            case "3": e.remover();
                                    System.out.println(">> Aperte ENTER para continuar <<");
                                    entrada.nextLine();
                                    break;

                            case "4": e.exibir();
                                    System.out.println(">> Aperte ENTER para voltar <<");
                                    entrada.nextLine();
                                    break;
                            case "0": break;
                            default: System.out.println(">> Opção inválida! <<");
                                    break;
                        }
                    }
                    j = "1";
                        break;
                case "3": 
                    while(!"0".equals(j)){
                        System.out.println("\n>>>>>>>>>> GERENCIAR CLIENTES <<<<<<<<<<");
                        System.out.println("1 -> Adicionar cliente");
                        System.out.println("2 -> Editar cliente");
                        System.out.println("3 -> Remover cliente");
                        System.out.println("4 -> Exibir clientes cadastrados");
                        System.out.println("0 -> Voltar");
                        System.out.println("________________________________________");
                        j = entrada.nextLine();
                        switch(j){
                            case "1": c.inserir();
                                    break;
                            case "2": c.editar();
                                    System.out.println(">> Aperte ENTER para continuar <<");
                                    entrada.nextLine();
                                    break;
                            case "3": c.remover();
                                    System.out.println(">> Aperte ENTER para continuar <<");
                                    entrada.nextLine();
                                    break;

                            case "4": c.exibir();
                                    System.out.println(">> Aperte ENTER para voltar <<");
                                    entrada.nextLine();
                                    break;
                            case "0": break;
                            default: System.out.println(">> Opção inválida! <<");
                                    break;
                        }
                    }
                    j = "1";
                        break;
                case "0": System.out.println(">> Finalizando... <<");
                        break;
                default: System.out.println(">> Opção inválida! <<");
                        break;
            }
        }       
    }
}
   
