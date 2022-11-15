import entidades. *;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDate;
public class Principal {
    private static Conta contaPoupanca;
    private static Conta contaCorrente;

    private static void setup(){
        Endereco endereco = new Endereco("Rua justiano macedo ", 404, "pedrinhas", "picos", "PI");
        Cliente cliente = new Cliente("Carolyne", "999.999.999-99", LocalDate.parse("2002-03-17"));
        cliente.setEndereco(endereco);
        contaPoupanca  = new ContaPoupanca(1383, 54782, 1000.0, 1.10, cliente, new Email());
        contaCorrente = new ContaCorrente(3900, 19780, 2000.0, 500.0, cliente, new Sms());

    }

    public static void main(String[] args){
        setup();
        depositarContaPoupancaTest();
        transferirContaPoupancaTest();
        depositarContaCorrenteTest();
        sacarContaCorrenteTest();
        transferirContaCorrenteTest();

    }
    private static void depositarContaPoupancaTest(){
        System.out.println("-----TESTE DEPOSITO CONTA POUPANCA------");
        System.out.println("saldo inicial: " + contaPoupanca.getSaldo());
        contaPoupanca.depositar(190.0);
        System.out.println("saldo final: " + contaPoupanca.getSaldo());

    }
    private static void transferirContaPoupancaTest(){
        System.out.println("-----TESTE TRANFERENCIA CONTA POUPANCA-----");
        System.out.println("saldo inicial: " + contaPoupanca.getSaldo());
        contaPoupanca.transfere(500.0, contaCorrente);
        System.out.println("saldo final: " + contaCorrente.getSaldo());
    }
    private static void depositarContaCorrenteTest(){
        System.out.println("----TESTE DEPOSITO CONTA CORRENTE--------");
        System.out.println("saldo inicial: " + contaCorrente.getSaldo());
        contaCorrente.depositar(200.0);
        System.out.println("saldo final: " + contaCorrente.getSaldo());

    }
    private static void sacarContaCorrenteTest(){
        System.out.println("----TESTE SACAR CONTA CORRENTE--------");
        System.out.println("saldo inicial: " + contaCorrente.getSaldo());
        contaCorrente.sacar(50.0);
        System.out.println("saldo final: " + contaCorrente.getSaldo());
    }
    private static void transferirContaCorrenteTest(){
        System.out.println("-----TESTE TRANFERENCIA CONTA CORRENTE-------");
        System.out.println("saldo inicial: " +  contaCorrente.getSaldo());
        contaCorrente.transfere(58.0, contaPoupanca);
        System.out.println("saldo final: " + contaCorrente.getSaldo());
    }
}
