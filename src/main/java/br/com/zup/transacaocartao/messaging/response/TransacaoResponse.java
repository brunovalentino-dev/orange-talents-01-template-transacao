package br.com.zup.transacaocartao.messaging.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zup.transacaocartao.model.Transacao;

public class TransacaoResponse {

	private String id;
	private BigDecimal valor;
	private EstabelecimentoResponse estabelecimento;
	private CartaoResponse cartao;
	private LocalDateTime efetivadaEm;
	
	@Deprecated
	public TransacaoResponse() {}
	
	public TransacaoResponse(String id, BigDecimal valor, EstabelecimentoResponse estabelecimento, CartaoResponse cartao,
			LocalDateTime efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstabelecimentoResponse getEstabelecimento() {
		return estabelecimento;
	}

	public CartaoResponse getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	public Transacao toEntity() {
		return new Transacao(id, valor, cartao.toEntity(), estabelecimento.toEntity(), efetivadaEm);
	} 
	
	@Override
	public String toString() {
		return "Transacao [id=" + id + ", valor=" + valor + ", estabelecimento=" + estabelecimento + ", cartao="
				+ cartao + ", efetivadaEm=" + efetivadaEm + "]";
	}
	
}
