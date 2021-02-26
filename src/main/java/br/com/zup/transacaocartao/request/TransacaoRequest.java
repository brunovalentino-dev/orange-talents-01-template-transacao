package br.com.zup.transacaocartao.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class TransacaoRequest {

	@NotBlank
	private String numeroCartao;
	
	@NotBlank
	@Email
	private String email;

	public TransacaoRequest(@NotBlank String numeroCartao, @NotBlank @Email String email) {
		this.numeroCartao = numeroCartao;
		this.email = email;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public String getEmail() {
		return email;
	}
	
}
