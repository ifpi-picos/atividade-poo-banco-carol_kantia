package entidades;

public class Sms implements Notificacao{
    @Override
    public void enviaNotificacao(String operacao, double valor) {
        System.out.printf("SMS: Operação %s com valor de %.2f. Realizada com sucesso!\n", operacao, valor);
    }
}
