package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.VendasDAO;
import br.com.fiap.to.VendasTO;

public class VendasBO {
	
	private VendasDAO vda = null;

    public List<VendasTO> listagem() {
    	vda = new VendasDAO();
        return vda.select();
    }

    public VendasTO listagem(int cod) {
    	vda = new VendasDAO();
        return vda.select(cod);
    }

    public boolean cadastrarProduto(VendasTO venda) {
    	vda = new VendasDAO();
        return vda.insert(venda);
    }

    public boolean atualizarProduto(VendasTO venda) {
    	vda = new VendasDAO();
        return vda.update(venda);
    }

    public void excluir(int cod) {
    	vda = new VendasDAO();
    	vda.delete(cod);
    }

}
