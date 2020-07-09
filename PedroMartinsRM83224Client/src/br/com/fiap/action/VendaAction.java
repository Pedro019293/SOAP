package br.com.fiap.action;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bo.VendasBO;
import br.com.fiap.to.VendasTO;

/**
 * Servlet implementation class VendaAction
 */
@WebServlet({ "/VendaAction", "/listagem", "/listar", "/adicionar", "/alterar", "/remover" })
public class VendaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VendasBO vbo = new VendasBO(); 
	private VendasTO venda = null;
       
    public VendaAction() {
        super();

    }

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		if (req.getRequestURI().equals("/PedroMartinsRM83224Client/listagem")) {

			listagem(req, res);

		} else if (req.getRequestURI().equals("/PedroMartinsRM83224Client/listar")) {

			listar(req, res);

		} else if (req.getRequestURI().equals("/PedroMartinsRM83224Client/adicionar")) {
			
			remover(req, res);
			
		} else if (req.getRequestURI().equals("/PedroMartinsRM83224Client/remover")) {
			
			adicionar(req, res);
			
		} else if (req.getRequestURI().equals("/PedroMartinsRM83224Client/alterar")) {

			alterar(req, res);
			
		}
		
		
		
	}
	
	
	protected void listagem(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		VendasTO[] vto = vbo.listagem();
		
		req.setAttribute("listaVendas", vto);
		
		req.setAttribute("controle", "lista-vendas");
		
		req.setAttribute("action-form", "adicionar");
		
		req.getRequestDispatcher("index.jsp").forward(req, res);
		
	}
	
	
	protected void listar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int cod = Integer.parseInt(req.getParameter("codProd"));
		
		VendasTO vto = vbo.listagem(cod);
		
		req.setAttribute("vendaObj", vto);
		
		req.setAttribute("action_form", "alterar");
		
		req.getRequestDispatcher("index.jsp").forward(req, res);
		
	}
	
	
	protected void adicionar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		venda = new VendasTO();
		venda.setCodigo(Integer.parseInt(req.getParameter("txtCodVenda")));
		venda.setNomeCliente(req.getParameter("txtNomeCliente"));
		venda.setDataVenda(Calendar.getInstance());
		venda.setDescricao(req.getParameter("txtDesc"));
		venda.setSituacaoPagamento(Boolean.parseBoolean(req.getParameter("txtSituacaoPag")));
		
		vbo = new VendasBO();
		vbo.cadastrar(venda);
		
		req.setAttribute("controle", "lista-venda");

		req.setAttribute("action-form", "adicionar");
		
		req.getRequestDispatcher("listagem").forward(req, res);
		
		
	}
	
	
	protected void alterar (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		venda = new VendasTO();
		venda.setCodigo(Integer.parseInt(req.getParameter("txtCodVenda")));
		venda.setNomeCliente(req.getParameter("txtNomeCliente"));
		venda.setDataVenda(Calendar.getInstance());
		venda.setDescricao(req.getParameter("txtDesc"));
		venda.setSituacaoPagamento(Boolean.parseBoolean(req.getParameter("txtSituacaoPag")));
		
		vbo = new VendasBO();
		vbo.atualizar(venda);
		
		req.setAttribute("controle", "lista-venda");

		req.setAttribute("action-form", "adicionar");
		
		req.getRequestDispatcher("listagem").forward(req, res);
		
	}
	
	
	protected void remover (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int cod = Integer.parseInt(req.getParameter("codProd"));
		
		vbo.excluir(cod);
		
		req.setAttribute("controle", "lista-venda");
		
		req.setAttribute("action-form", "adicionar");
		
		req.getRequestDispatcher("listagem").forward(req, res);
		
	}
	
	

}
