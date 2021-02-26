package br.com.zup.transacaocartao.messaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zup.transacaocartao.messaging.response.TransacaoResponse;
import br.com.zup.transacaocartao.model.Transacao;
import br.com.zup.transacaocartao.repository.TransacaoRepository;

@Component
public class TransacaoListener {

	private TransacaoRepository transacaoRepository;
	
	public TransacaoListener(TransacaoRepository transacaoRepository) {
		this.transacaoRepository = transacaoRepository;
	}

	@KafkaListener(topics = "transacoes")
    public void ouvir(TransacaoResponse transacaoResponse) {
		System.out.println("Nova transação registrada: ");
		System.out.println(transacaoResponse.toString());
		
		Transacao transacao = transacaoResponse.toEntity();	
		transacaoRepository.save(transacao);		
	}		
	
}
