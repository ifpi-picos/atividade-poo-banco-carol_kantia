package tarefas;

import entidades.*;

import java.util.Scanner;

public class CriarConta {
    private final Scanner sc;
    private final Cliente cliente;

    public CriarConta(Scanner sc, Cliente cliente) {
        this.sc = sc;
        this.cliente = cliente;
    }
    public void executar() {
        System.out.println("===================== CRIE UMA CONTA ===================");
        System.out.println("=======[ POUPANÇA: 1 ] [ CORRENTE: 2 ] [ LISTAR: 3 ] [ SAIR: 4 ]======");
        System.out.print("=>: ");
        int opcao = Integer.parseInt(sc.nextLine());
        switch (opcao) {
            case 1:
                criarContaPoupanca();
                break;
            case 2:
                criarContaCorrente();
                break;
            case 3:
                listarContas();
                break;
            case 4:
                return;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private void criarContaPoupanca() {
        System.out.println("Agencia: ");
        int agencia = Integer.parseInt(sc.nextLine());
        System.out.println("Numero: ");
        int numero = Integer.parseInt(sc.nextLine());
        System.out.println("Saldo inicial: ");
        double saldo = Double.parseDouble(sc.nextLine());
        Conta contaPoupanca = new ContaPoupanca(agencia, numero, saldo, 1.10, cliente, new Email());
        cliente.adicionarConta(contaPoupanca);
        System.out.println("Parabéns, "+cliente.getNome()+". Sua conta poupanca foi criada!");
    }

    private void criarContaCorrente() {
        System.out.println("Agencia: ");
        int agencia = Integer.parseInt(sc.nextLine());
        System.out.println("Numero: ");
        int numero = Integer.parseInt(sc.nextLine());
        System.out.println("Saldo inicial: ");
        double saldo = Double.parseDouble(sc.nextLine());
        Conta contaCorrente = new ContaCorrente(agencia, numero, saldo, 500.0, cliente, new Sms());
        cliente.adicionarConta(contaCorrente);
        System.out.println("Parabéns, "+cliente.getNome()+". Sua conta corrente foi criada!");
    }

    private void listarContas() {
        System.out.println("===================== SUAS CONTAS ===================");
        System.out.println("=======[ DEPOSITAR: 1 ] [ SACAR: 2 ] [ TRANSFERIR: 3 ] [ VOLTAR: 4 ]======");
        for (Conta conta: cliente.getContas()) {
            if (conta instanceof ContaPoupanca) {
                System.out.printf("# tipo: poupanca, agencia: %d, numero: %d, saldo: %.2f\n", conta.getAgencia(), conta.getNumero(), conta.getSaldo());
            } else {
                System.out.printf("# tipo: corrente, agencia: %d, numero: %d, saldo: %.2f\n", conta.getAgencia(), conta.getNumero(), conta.getSaldo());
            }
        }
        System.out.print("=>: ");
        int opcao = Integer.parseInt(sc.nextLine());
        switch (opcao) {
            case 1:
                (new DepositarEmConta(sc, cliente)).executar();
                break;
            case 2:
                (new SacarDaConta(sc, cliente)).executar();
                break;
            case 3:
                (new TransferirDeConta(sc, cliente)).executar();
                break;
            case 4:
                return;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }
}
