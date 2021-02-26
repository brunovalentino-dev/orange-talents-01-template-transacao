package br.com.zup.transacaocartao.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Cartao {

	@NotBlank
	private String numeroCartao;

	@NotBlank
	private String email;
	
	@Deprecated
	public Cartao() {}

	public Cartao(@NotBlank String numeroCartao, @NotBlank String email) {
		super();
		this.numeroCartao = numeroCartao;
		this.email = email;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Cartao [numeroCartao=" + numeroCartao + ", email=" + email + "]";
	}

}
