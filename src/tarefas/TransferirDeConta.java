package tarefas;

import entidades.Cliente;
import entidades.Conta;

import java.util.Scanner;

public class TransferirDeConta {
    private final Scanner sc;
    private final Cliente cliente;

    public TransferirDeConta(Scanner sc, Cliente cliente) {
        this.sc = sc;
        this.cliente = cliente;
    }
    public void executar() {
        System.out.println("===================== TRANSFERENCIA ===================");
        System.out.println("Numero da conta: ");
        int numero = Integer.parseInt(sc.nextLine());
        System.out.println("Numero da conta destino: ");
        int numeroDestino = Integer.parseInt(sc.nextLine());
        System.out.println("Valor: ");
        double valor = Integer.parseInt(sc.nextLine());
        Conta conta = cliente.buscarContaPorNumero(numero);
        Conta contaDestino = cliente.buscarContaPorNumero(numeroDestino);
        if (conta == null) {
            System.out.println("Conta inválida!");
            return;
        }
        if (contaDestino == null) {
            System.out.println("Conta de destino inválida!");
            return;
        }
        conta.transfere(valor, contaDestino);
    }
}
