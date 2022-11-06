import entidades.Cliente;
import tarefas.CriarCliente;
import tarefas.CriarConta;
import tarefas.CriarEndereco;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Principal {
    private static boolean loopMain = true;
    private static final Scanner sc = new Scanner(System.in);
    private static Cliente cliente;

    public static void main(String[] args) {
        criarCliente();
        do {
            System.out.println("===================== BEM VINDO AO BANCO MAUT ===================");
            System.out.println("=======[ CONTA: 1 ] [ CRIAR ENDEREÇO: 2 ] [ SAIR: 3 ]======");
            System.out.print("=>: ");
            int opcao = Integer.parseInt(sc.nextLine());
            switch (opcao) {
                case 1:
                    (new CriarConta(sc, cliente)).executar();
                    break;
                case 2:
                    (new CriarEndereco(sc, cliente)).executar();
                    break;
                case 3:
                    loopMain = false;
                    System.out.println("FIM!!!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (loopMain);
        sc.close();
    }

    private static void criarCliente() {
        try {
            cliente = (new CriarCliente(sc)).executar();
            System.out.println("Cadastro ralizado com sucesso!");
        } catch (DateTimeParseException e) {
            System.out.println("Data de nascimento inválida!");
            criarCliente();
        }
    }
}
