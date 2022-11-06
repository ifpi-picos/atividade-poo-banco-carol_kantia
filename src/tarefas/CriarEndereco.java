package tarefas;

import entidades.Cliente;
import entidades.Endereco;

import java.util.Scanner;

public class CriarEndereco {
    private final Scanner sc;
    private final Cliente cliente;

    public CriarEndereco(Scanner sc, Cliente cliente) {
        this.sc = sc;
        this.cliente = cliente;
    }
    public void executar() {
        System.out.println("===================== CADASTRO DE ENDEREÇO ===================");
        System.out.println("Rua: ");
        String rua = sc.nextLine();
        System.out.println("Numero: ");
        int numero = Integer.parseInt(sc.nextLine());
        System.out.println("Bairro: ");
        String bairro = sc.nextLine();
        System.out.println("Cidade: ");
        String cidade = sc.nextLine();
        System.out.println("Estado: ");
        String estado = sc.nextLine();
        Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado);
        cliente.setEndereco(endereco);
        System.out.println("Endereço cadastrado com sucesso!");
    }
}
