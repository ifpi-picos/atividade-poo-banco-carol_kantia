package entidades;

public class Email implements Notificacao{
    @Override
    public void enviaNotificacao(String operacao, double valor) {
        System.out.printf("E-mail: Operação %s com valor de %.2f. Realizada com sucesso!\n", operacao, valor);
    }
}
