import entidades.*;

import java.time.LocalDate;

public class Principal {
    private static Conta contaPoupanca;
    public static Conta contaCorrente;

    private static void setup() {
        Endereco endereco = new Endereco("Rua Justino Macedo", 404, "Pedrinhas", "Picos", "PI");
        Cliente cliente = new Cliente("Carolyne Silva", "999.999.999-99", LocalDate.parse("2002-03-17"));
        cliente.setEndereco(endereco);
        contaPoupanca = new ContaPoupanca(1383, 54782, 1000.0, 1.10, cliente, new Email());
        contaCorrente = new ContaCorrente(3900, 19780, 2000.0, 500.0, cliente, new Sms());
    }

    public static void main(String[] args) {
        setup();
        depositarContaPoupancaTest();
        transferirContaPoupancaTest();
        depositarContaCorrenteTest();
        sacarContaCorrenteTest();
        transferirContaCorrenteTest();
    }

    private static void depositarContaPoupancaTest() {
        System.out.println("------- TESTE DEPOSITO CONTA POUPANCA -------");
        System.out.println("SALDO INICIAL: " + contaPoupanca.getSaldo());
        contaPoupanca.depositar(100.0);
        System.out.println("SALDO FINAL: " + contaPoupanca.getSaldo());
    }

    private static void transferirContaPoupancaTest() {
        System.out.println("------- TESTE TRANSFERENCIA CONTA POUPANCA -------");
        System.out.println("SALDO INICIAL: " + contaPoupanca.getSaldo());
        contaPoupanca.transfere(500.0, contaCorrente);
        System.out.println("SALDO FINAL: " + contaPoupanca.getSaldo());
    }

    private static void depositarContaCorrenteTest() {
        System.out.println("------- TESTE DEPOSITO CONTA CORRENTE -------");
        System.out.println("SALDO INICIAL: " + contaCorrente.getSaldo());
        contaCorrente.depositar(300.0);
        System.out.println("SALDO FINAL: " + contaCorrente.getSaldo());
    }

    private static void sacarContaCorrenteTest() {
        System.out.println("------- TESTE SACAR CONTA CORRENTE -------");
        System.out.println("SALDO INICIAL: " + contaCorrente.getSaldo());
        contaCorrente.sacar(600.0);
        System.out.println("SALDO FINAL: " + contaCorrente.getSaldo());
    }

    private static void transferirContaCorrenteTest() {
        System.out.println("------- TESTE TRANSFERENCIA CONTA CORRENTE -------");
        System.out.println("SALDO INICIAL: " + contaCorrente.getSaldo());
        contaCorrente.transfere(100.0, contaPoupanca);
        System.out.println("SALDO FINAL: " + contaCorrente.getSaldo());
    }
}
