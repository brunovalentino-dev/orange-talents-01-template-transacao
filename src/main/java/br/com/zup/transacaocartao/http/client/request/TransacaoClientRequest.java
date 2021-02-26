package br.com.zup.transacaocartao.http.client.request;

public class TransacaoClientRequest {

	private String id;
	private String email;
	
	public TransacaoClientRequest(String id, String email) {
		this.id = id;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
	
}
