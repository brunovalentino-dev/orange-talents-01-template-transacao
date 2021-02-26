package br.com.zup.transacaocartao.http.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.zup.transacaocartao.http.client.response.ConsultaCartaoResponse;

@FeignClient(name = "consultaCartaoClient", url = "${contas.client.host}")
public interface ConsultaCartaoClient {

	@GetMapping("/api/cartoes/{id}")
    ConsultaCartaoResponse consultarCartao(@PathVariable String id);
	
}
