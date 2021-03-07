package gerenciamento_cliente_venda;

import farmacia.Farmacia;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente implements Farmacia{
    
    private String nome, endereco, email, rg;
    
    ArrayList<Cliente> Clientes = new ArrayList<>();

    Scanner input = new Scanner(System.in);
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public ArrayList<Cliente> getClientes() {
        return Clientes;
    }

    public void setClientes(ArrayList<Cliente> Clientes) {
        this.Clientes = Clientes;
    }
    
    @Override
    public void inserir() {
        
        Cliente cliente = new Cliente();
        
        System.out.println("\n>>>>>>>>>> ADICIONAR CLIENTE <<<<<<<<<<<");
                
        System.out.print("Nome: ");
        cliente.setNome(input.nextLine());
        
        System.out.print("RG: ");
        cliente.setRg(input.nextLine());
        
        if(verificar(cliente.getRg())){
            System.out.println("\n>> Este cliente já está cadastrado! <<");
        }else{
            System.out.print("Endereço: ");
            cliente.setEndereco(input.nextLine());

            System.out.print("Email: ");
            cliente.setEmail(input.nextLine());

            Clientes.add(cliente);
        }
        
        
    }

    @Override
    public boolean verificar(String rgCliente) {
        for(int i = 0; i < Clientes.size(); i++){
            if(rgCliente.equals(Clientes.get(i).getRg())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void editar() {
        System.out.println("\n>>>>>>>>>> EDITAR CLIENTE <<<<<<<<<<<<<<");
        
        System.out.print("Digite o RG do cliente: ");
        String rgCliente = input.nextLine();
        if(verificar(rgCliente)){
            for(int i = 0; i < Clientes.size(); i++){
                if(rgCliente.equals(Clientes.get(i).getRg())){
                    System.out.println("| Nome: " + Clientes.get(i).getNome());
                    System.out.println("| RG: " + Clientes.get(i).getRg());
                    System.out.println("| Endereço: " + Clientes.get(i).getEndereco());
                    System.out.println("| Email: " + Clientes.get(i).getEndereco());
                    System.out.println("____________________________________");
                    
                    System.out.println("(Para não alterar o dado basta deixar o campo vazio)");
                    
                    System.out.print("Novo nome: ");
                    String novo_nome = input.nextLine();
                    if(!"".equals(novo_nome))
                        Clientes.get(i).setNome(novo_nome);
                    
                    System.out.print("Novo RG: ");
                    String novo_rg = input.nextLine();
                    if(!"".equals(novo_rg))
                        Clientes.get(i).setRg(novo_rg);
                    
                    System.out.print("Novo endereço: ");
                    String novo_endereco = input.nextLine();
                    if(!"".equals(novo_endereco))
                        Clientes.get(i).setEndereco(novo_endereco);
                    
                    System.out.print("Novo e-mail: ");
                    String novo_email = input.nextLine();
                    if(!"".equals(novo_email))
                        Clientes.get(i).setEmail(novo_email);
                    
                }
            }
            
            System.out.println(">> Cliente editado com sucesso! <<\n");
        }else{
            System.out.println(">> Impossível editar! Pois o cliente não possui cadastro. <<\n");
        }
    }

    @Override
    public void remover() {
        System.out.println("\n>>>>>>>>>> REMOVER CLIENTE <<<<<<<<<<");
        
        System.out.print("Digite o RG do cliente: ");
        String rgCliente = input.nextLine();
        
        if(verificar(rgCliente)){
            for(int i = 0; i < Clientes.size(); i++){
                if(rgCliente.equals(Clientes.get(i).getRg())){
                    Clientes.remove(i);
                }
            }
            System.out.println(">> Cliente removido com sucesso! <<\n");
        }else{
            System.out.println(">> Impossível remover! Pois o cliente não é cadastrado. <<\n");
        }
    }

    @Override
    public void exibir() { //lista todos os clientes
        System.out.println("\n>>>>>>>>>> EXIBINDO CLIENTE <<<<<<<<<<<<");
        for(Cliente c: this.Clientes){
            System.out.println("| Nome: " + c.getNome());
            System.out.println("| RG: " + c.getRg());
            System.out.println("| Endereço: " + c.getEndereco());
            System.out.println("| E-mail: " + c.getEmail());
            System.out.println("________________________________________");
        }
    }
    
}
