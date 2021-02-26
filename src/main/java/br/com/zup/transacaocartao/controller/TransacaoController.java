package br.com.zup.transacaocartao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.transacaocartao.http.client.ConsultaCartaoClient;
import br.com.zup.transacaocartao.http.client.TransacaoClient;
import br.com.zup.transacaocartao.http.client.request.TransacaoClientRequest;
import br.com.zup.transacaocartao.http.client.response.ConsultaCartaoResponse;
import br.com.zup.transacaocartao.model.Transacao;
import br.com.zup.transacaocartao.repository.TransacaoRepository;
import br.com.zup.transacaocartao.request.TransacaoRequest;
import feign.FeignException;

@RestController
@RequestMapping(value = "/api/cartoes")
public class TransacaoController {
			
	private TransacaoClient transacaoClient;
	private ConsultaCartaoClient consultaCartaoClient;
	private TransacaoRepository transacaoRepository;
	
	public TransacaoController(TransacaoClient transacaoClient, ConsultaCartaoClient consultaCartaoClient,
			TransacaoRepository transacaoRepository) {
		this.transacaoClient = transacaoClient;
		this.consultaCartaoClient = consultaCartaoClient;
		this.transacaoRepository = transacaoRepository;
	}

	@PostMapping("/transacoes")
    public ResponseEntity<?> gerarTransacao(@Valid @RequestBody TransacaoRequest request) {
		ConsultaCartaoResponse consultaCartaoResponse = null;
		
		try {
			consultaCartaoResponse = 
					consultaCartaoClient.consultarCartao(request.getNumeroCartao());
		} 
		catch (FeignException exception) {
			Map<String, String> erros = new HashMap<>();
			erros.put("Erro registrado", "O cartão informado não foi encontrado!");
            
            return ResponseEntity.unprocessableEntity().body(erros);
		}
		
        TransacaoClientRequest transacaoClientRequest = 
        		new TransacaoClientRequest(consultaCartaoResponse.getId(), 
        				this.gerarEmail(consultaCartaoResponse.getTitular()));
        
        try {
            transacaoClient.gerarTransacao(transacaoClientRequest);
        }
        catch (FeignException exception) {
            Map<String, String> erros = new HashMap<>();
            erros.put("Erro registrado", "O cartão informado não foi encontrado!");
            
            return ResponseEntity.unprocessableEntity().body(erros);
        }       

        return ResponseEntity.ok("Transações habilitadas para o cartão!");
    }	
	
	@DeleteMapping("/transacoes")
    public ResponseEntity<?> pararTransacao(@RequestParam String id) {
		ConsultaCartaoResponse consultaCartaoResponse = null;
		
		try {
			consultaCartaoResponse = consultaCartaoClient.consultarCartao(id);
		} 
		catch (FeignException exception) {
			Map<String, String> erros = new HashMap<>();
			erros.put("Erro registrado", "O cartão informado não foi encontrado!");
            
            return ResponseEntity.unprocessableEntity().body(erros);
		}		       
        
        try {
            transacaoClient.pararTransacao(consultaCartaoResponse.getId());
        }
        catch (FeignException exception) {
            Map<String, String> erros = new HashMap<>();
            erros.put("Erro registrado", "O cartão informado não foi encontrado!");
            
            return ResponseEntity.unprocessableEntity().body(erros);
        }       

        return ResponseEntity.ok("Transações desabilitadas para o cartão!");
    }
	
	@GetMapping("/transacoes")
	public ResponseEntity<?> listarUltimasCompras(@RequestParam String id) {		
		try {
			consultaCartaoClient.consultarCartao(id);
		} 
		catch (FeignException exception) {
			Map<String, String> erros = new HashMap<>();
			erros.put("Erro registrado", "O cartão informado não foi encontrado!");
            
            return ResponseEntity.unprocessableEntity().body(erros);
		}

		List<Transacao> ultimasTransacoes = 
				transacaoRepository.findTop10ByCartao_NumeroCartaoOrderByEfetivadaEmDesc(id);

		return ResponseEntity.ok(ultimasTransacoes.toString());
	}
	
	private String gerarEmail(String titular) {
		String email = titular.trim().toLowerCase() + "@email.com";
		return email;
	}

}
