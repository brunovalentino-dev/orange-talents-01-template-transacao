package br.com.zup.transacaocartao.http.client;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.zup.transacaocartao.http.client.request.TransacaoClientRequest;

@FeignClient(name = "cartaoClient", url = "${transacao.client.host}")
public interface TransacaoClient {

	@PostMapping("/api/cartoes")
	void gerarTransacao(@Valid @RequestBody TransacaoClientRequest request);
	
	@DeleteMapping("/api/cartoes/{id}")
	void pararTransacao(@PathVariable String id);
	
}
