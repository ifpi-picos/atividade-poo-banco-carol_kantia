package tarefas;

import entidades.Cliente;
import entidades.Conta;

import java.util.Scanner;

public class SacarDaConta {
    private final Scanner sc;
    private final Cliente cliente;

    public SacarDaConta(Scanner sc, Cliente cliente) {
        this.sc = sc;
        this.cliente = cliente;
    }
    public void executar() {
        System.out.println("===================== SACAR DA CONTA ===================");
        System.out.println("Numero da conta: ");
        int numero = Integer.parseInt(sc.nextLine());
        System.out.println("Valor: ");
        double valor = Integer.parseInt(sc.nextLine());
        Conta conta = cliente.buscarContaPorNumero(numero);
        if (conta != null) {
            conta.sacar(valor);
        } else {
            System.out.println("Conta inválida!");
        }
    }
}
