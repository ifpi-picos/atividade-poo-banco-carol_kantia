package entidades;

public class ContaPoupanca extends Conta {
    private double rendimento;
    public ContaPoupanca(int agencia, int numero, double saldo, double rendimento, Cliente cliente, Notificacao notificacao) {
        super(agencia, numero, saldo, cliente, notificacao);
        this.rendimento = rendimento;
    }

    @Override
    public void transfere(double valor, Conta contaDestino) {
        double taxa = this.getSaldo() * 0.05;
        double valorFinal = taxa + valor;
        super.transfere(valorFinal, contaDestino);
    }

    @Override
    public void depositar(double valor) {
        double rendimentoValor = calcularRendimento(valor);
        super.depositar(rendimentoValor);
    }
    private double calcularRendimento(double valor) {
        return  this.rendimento * valor;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }
}
