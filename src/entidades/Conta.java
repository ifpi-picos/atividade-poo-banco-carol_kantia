package entidades;

abstract public class Conta {
    private final int agencia;
    private final int numero;
    private double saldo;
    private final Cliente cliente;
    private Notificacao notificacao;

    public Conta(int agencia, int numero, double saldo, Cliente cliente, Notificacao notificacao) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
        this.notificacao = notificacao;
    }

    public void depositar(double valor) {
        this.saldo = this.saldo + valor;
        notificacao.enviaNotificacao("DEPOSITO", valor);
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
           this.saldo = this.saldo - valor;
            notificacao.enviaNotificacao("SAQUE", valor);
           return true;
        } else {
            System.out.println("Você não possui saldo suficiente!");
        }
        return false;
    }

    public void transfere(double valor, Conta contaDestino) {
        if (this.sacar(valor)) {
            notificacao.enviaNotificacao("TRANSFERENCIA", valor);
            contaDestino.depositar(valor);
        }
    }

    public void enviaNotificacao(String operacao, double valor){
        notificacao.enviaNotificacao(operacao, valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }
}
