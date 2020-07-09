package br.com.fiap.to;

import java.util.Calendar;


public class VendasTO {
	
	private int codigo;
	
	private String nomeCliente;
	
	private Calendar dataVenda;
	
	private String descricao;
	
	private double valor;
	
	private boolean situacaoPagamento;

	public VendasTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VendasTO(int codigo,String nomeCliente, Calendar dataVenda, String descricao, double valor, boolean situacaoPagamento) {
		super();
		this.codigo = codigo;
		this.nomeCliente = nomeCliente;
		this.dataVenda = dataVenda;
		this.descricao = descricao;
		this.valor = valor;
		this.situacaoPagamento = situacaoPagamento;
	}
	
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Calendar getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isSituacaoPagamento() {
		return situacaoPagamento;
	}

	public void setSituacaoPagamento(boolean situacaoPagamento) {
		this.situacaoPagamento = situacaoPagamento;
	}
	
	
	
	
	
	

}
