package br.com.zup.transacaocartao.messaging.response;

import br.com.zup.transacaocartao.model.Estabelecimento;

public class EstabelecimentoResponse {

	private String nome;
	private String cidade;
	private String endereco;
	
	@Deprecated
	public EstabelecimentoResponse() {}
	
	public EstabelecimentoResponse(String nome, String cidade, String endereco) {
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}
	
	public Estabelecimento toEntity() {
		return new Estabelecimento(nome, cidade, endereco);
	}

	@Override
	public String toString() {
		return "Estabelecimento [nome=" + nome + ", cidade=" + cidade + ", endereco=" + endereco + "]";
	}
	
}
