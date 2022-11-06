package tarefas;

import entidades.Cliente;

import java.time.LocalDate;
import java.util.Scanner;

public class CriarCliente {
    private final Scanner sc;
    public CriarCliente(Scanner sc) {
        this.sc = sc;
    }
    public Cliente executar() {
        System.out.println("===================== CADASTRO DE CLIENTE ===================");
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("CPF(999.999.999-99): ");
        String cpf = sc.nextLine();
        System.out.println("Data de nascimento(yyyy-MM-dd): ");
        String dataNascimento = sc.nextLine();
        return new Cliente(nome, cpf, LocalDate.parse(dataNascimento));
    }
}
