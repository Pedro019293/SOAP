package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.to.VendasTO;

public class VendasDAO {
	
	public static List<VendasTO> listaVendas = null;

	public VendasDAO() {
		
		if(listaVendas == null) {
			listaVendas = new ArrayList<VendasTO>();
			
			VendasTO vto = new VendasTO(1,"Pedro", new GregorianCalendar(2019,Calendar.DECEMBER,25), "Arvore de Natal",250.0, true);
			listaVendas.add(vto);
			
			vto = new VendasTO(2,"Gustavo", new GregorianCalendar(2018,Calendar.JANUARY,02), "Celular",1500.0, true);
			listaVendas.add(vto);
			
			vto = new VendasTO(3,"Marcelo", new GregorianCalendar(2020,Calendar.MARCH,21), "Caixa de Som",150.0, false);
			listaVendas.add(vto);
			
			vto = new VendasTO(4,"Felipe", new GregorianCalendar(2020,Calendar.APRIL,01), "Microfone",100.0, true);
			listaVendas.add(vto);
			
			vto = new VendasTO(5,"Luiz", new GregorianCalendar(2020,Calendar.MARCH,10), "Notebook",3990.0, false);
			listaVendas.add(vto);
			
			vto = new VendasTO(6,"Josefina", new GregorianCalendar(2020,Calendar.APRIL,20), "Estojo de Maquiagem",259.0, true);
			listaVendas.add(vto);
			
			vto = new VendasTO(7,"Gabriel", new GregorianCalendar(2019,Calendar.NOVEMBER,30), "Capa de Celular",25.0, true);
			listaVendas.add(vto);
			
			vto = new VendasTO(8,"Rafael", new GregorianCalendar(2020,Calendar.FEBRUARY,15), "TV 50'",2590.0, false);
			listaVendas.add(vto);
			
			vto = new VendasTO(9,"Emanuel", new GregorianCalendar(2019,Calendar.OCTOBER,03), "Fone de Ouvido",399.0, true);
			listaVendas.add(vto);
			
			vto = new VendasTO(10,"Maria", new GregorianCalendar(2019,Calendar.JULY,19), "Impressora",999.0, true);
			listaVendas.add(vto);
		
		}
		
	}
	
	public List<VendasTO> select(){
		return listaVendas;
	}
	
	public VendasTO select(int cod) {
		for (VendasTO v: listaVendas) {
			
			if(v.getCodigo() == cod) {
				return v;
			}
		}
		
		return null;
	}
	
	
	public boolean insert(VendasTO venda){
		
		if (venda != null){
			int cod = listaVendas.get(listaVendas.size()-1).getCodigo();
			venda.setCodigo(cod+1);
			return listaVendas.add(venda);		
		}
		return false;
	}

	
	public boolean update (VendasTO venda) {
		
		if(venda != null) {
			for (int i = 0; i < listaVendas.size(); i++) {
				if(listaVendas.get(i).getCodigo() == venda.getCodigo()) {
					listaVendas.set(i, venda);
					return true;
				}
			}
		}
		return false;
	}
	
	
	public boolean delete (int cod) {
		for (int i = 0; i < listaVendas.size(); i++) {
			if(listaVendas.get(i).getCodigo() == cod) {
				listaVendas.remove(i);
				return true;
			}
		}
		return false;
	}	
}
