package entidades;

public class ContaCorrente extends Conta {
    private double chequeEspecial;
    private int transacoes;
    public ContaCorrente(int agencia, int numero, double saldo, double chequeEspecial, Cliente cliente, Notificacao notificacao) {
        super(agencia, numero, saldo, cliente, notificacao);
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        double saldoComChequeEspecial = this.getSaldo() + chequeEspecial;
        if (valor <= saldoComChequeEspecial) {
            double saldoFinal = getSaldo() - valor;
            setSaldo(saldoFinal);
            enviaNotificacao("SAQUE", valor);
            return true;
        } else {
            System.out.println("Você não possui saldo suficiente!");
        }
        return false;
    }

    @Override
    public void transfere(double valor, Conta contaDestino) {
        if (this.transacoes <= 2) {
            super.transfere(valor, contaDestino);
            this.transacoes++;
        } else {
            double taxa = this.getSaldo() * 0.10;
            double valorFinal = taxa + valor;
            super.transfere(valorFinal, contaDestino);
        }
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
}
