package br.com.fiap.bo;

import br.com.fiap.repository.Servico;
import br.com.fiap.to.VendasTO;

public class VendasBO {
	
private Servico servico = null;
	
	public VendasTO[] listagem() {
		servico = new Servico();
		return servico.listar();
	}

	public VendasTO listagem(int cod) {
		servico = new Servico();
		return servico.listar(cod);
	}
	
	public void excluir(int cod) {
		servico = new Servico();
		servico.excluir(cod);
	}
	
	public void atualizar(VendasTO venda) {
		servico = new Servico();
		servico.alterar(venda, venda.getCodigo());
	}
	
	public void cadastrar(VendasTO venda) {
		servico = new Servico();
		servico.cadastrar(venda);
	}

}
