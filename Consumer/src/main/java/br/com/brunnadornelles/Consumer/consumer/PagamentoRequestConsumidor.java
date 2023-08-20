package br.com.brunnadornelles.Consumer.consumer;

import br.com.brunnadornelles.Consumer.producer.PagamentoErroProdutor;
import br.com.brunnadornelles.Consumer.producer.PagamentoSucessoProdutor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PagamentoRequestConsumidor {
    @Autowired
    private PagamentoErroProdutor erroProdutor;

    @Autowired
    private PagamentoSucessoProdutor sucessoProdutor;

    @RabbitListener(queues = { "pagamento-request-queue"})
    public void receberMensagem (@Payload Message message) {
        System.out.println(message);
        if (new Random().nextBoolean()) {
            sucessoProdutor.gerarResposta("Mensagem de sucesso Pagamento " + message);
        } else {
            erroProdutor.gerarResposta("ERRO no pagamento " + message);
        }
    }
}