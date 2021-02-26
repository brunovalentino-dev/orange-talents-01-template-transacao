package br.com.zup.transacaocartao.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Transacao {

	@Id
	@SequenceGenerator(name = "transacao", sequenceName = "transacao_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transacao")
	private Long id;
	
	@NotNull
	private BigDecimal valor;
	
	@NotBlank
	private String numeroTransacao;
	
	@Embedded
	@NotNull
	private Cartao cartao;
	
	@Embedded
	@NotNull
	private Estabelecimento estabelecimento;
	
	@NotNull
	private LocalDateTime efetivadaEm;

	@Deprecated
	public Transacao() {}

	public Transacao (@NotBlank String numeroTransacao, @NotNull BigDecimal valor, @NotNull Cartao cartao,
			@NotNull Estabelecimento estabelecimento, @NotNull LocalDateTime efetivadaEm) {
		this.numeroTransacao = numeroTransacao;
		this.valor = valor;
		this.cartao = cartao;
		this.estabelecimento = estabelecimento;
		this.efetivadaEm = efetivadaEm;
	}

	public Long getId() {
		return id;
	}

	public String getNumeroTransacao() {
		return numeroTransacao;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	@Override
	public String toString() {
		return "Transacao [id=" + id + ", numeroTransacao=" + numeroTransacao + ", cartao=" + cartao + ", estabelecimento="
				+ estabelecimento + ", efetivadaEm=" + efetivadaEm + "]";
	}
	
}
