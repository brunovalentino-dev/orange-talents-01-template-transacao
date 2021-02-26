package br.com.zup.transacaocartao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.transacaocartao.model.Transacao;

public interface TransacaoRepository extends CrudRepository<Transacao, Long> {

	List<Transacao> findTop10ByCartao_NumeroCartaoOrderByEfetivadaEmDesc(String numeroCartao);
	
}
