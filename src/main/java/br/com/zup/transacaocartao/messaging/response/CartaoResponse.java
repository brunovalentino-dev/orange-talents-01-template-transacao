package br.com.zup.transacaocartao.messaging.response;

import br.com.zup.transacaocartao.model.Cartao;

public class CartaoResponse {

	private String id;
	private String email;
	
	@Deprecated
	public CartaoResponse() {}
	
	public CartaoResponse(String id, String email) {
		this.id = id;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public Cartao toEntity() {
		return new Cartao(id, email);
	}
	
	@Override
	public String toString() {
		return "Cartao [id=" + id + ", email=" + email + "]";
	}
	
}
