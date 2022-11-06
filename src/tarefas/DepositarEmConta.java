package tarefas;

import entidades.Cliente;
import entidades.Conta;

import java.util.Scanner;

public class DepositarEmConta {

    private final Scanner sc;
    private final Cliente cliente;

    public DepositarEmConta(Scanner sc, Cliente cliente) {
        this.sc = sc;
        this.cliente = cliente;
    }
    public void executar() {
        System.out.println("===================== DEPOSITO EM CONTA ===================");
        System.out.println("Numero da conta: ");
        int numero = Integer.parseInt(sc.nextLine());
        System.out.println("Valor: ");
        double valor = Integer.parseInt(sc.nextLine());
        Conta conta = cliente.buscarContaPorNumero(numero);
        if (conta != null) {
            conta.depositar(valor);
        } else {
            System.out.println("Conta inválida!");
        }
    }
}
