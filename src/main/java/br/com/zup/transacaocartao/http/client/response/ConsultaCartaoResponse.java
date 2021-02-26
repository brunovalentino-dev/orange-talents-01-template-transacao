package br.com.zup.transacaocartao.http.client.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ConsultaCartaoResponse {

	private String id;
	private String titular;
	private LocalDateTime emitidoEm;
	private Long idProposta;
	private BigDecimal limite;

	public String getId() {
		return id;
	}

	public String getTitular() {
		return titular;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}

	public Long getIdProposta() {
		return idProposta;
	}

	public BigDecimal getLimite() {
		return limite;
	}
	
	@Override
	public String toString() {
		return "ConsultaCartaoResponse [id=" + id + ", titular=" + titular + ", emitidoEm=" + emitidoEm + ", idProposta="
				+ idProposta + ", limite=" + limite + "]";
	}
	
}
