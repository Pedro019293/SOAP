package br.com.fiap.repository;

import java.net.URI;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.to.VendasTO;

public class Servico {
	
	private Client cliente = Client.create();
    private WebResource resource = null;
    private ClientResponse response = null;
    
    
    public VendasTO[] listar() {
    	resource = cliente.resource("http://localhost:8080/PedroMartinsRM83224Server/rest/venda");
        response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
   
        if (response.getStatus() == 200) {
            return response.getEntity(VendasTO[].class);
        } else {
            return null;
        }
    }
    
    // ----------------------------- //
    
    public VendasTO listar(int cod) {
    	
    	resource = cliente.resource("http://localhost:8080/PedroMartinsRM83224Server/rest/venda/"+cod);
        response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
    	
        if (response.getStatus() == 200) {
            return response.getEntity(VendasTO.class);
        } else {
            return null;
        }
    }

    // ----------------------------- //
    
    public URI cadastrar (VendasTO venda) {
    	
    	 resource = cliente.resource("http://localhost:8080/PedroMartinsRM83224Server/rest/venda/");
         response = resource.type("application/json").post(ClientResponse.class, venda);

         if (response.getStatus() == 201) {
             return response.getLocation();
         } else {
             return null;
         }
    }
    
    
    public int alterar(VendasTO venda, int cod) {

        resource = cliente.resource("http://localhost:8080/PedroMartinsRM83224Server/rest/venda/" + cod);
        response = resource.type("application/json").put(ClientResponse.class, venda);

        if (response.getStatus() == 200) {
            return response.getStatus();
        } else {
            return response.getStatus();
        }

    }
    
    
   // ----------------------------- //
    
   public boolean excluir (int cod) {
	
	   resource = cliente.resource("http://localhost:8080/PedroMartinsRM83224Server/rest/venda/"+cod);
       response = resource.delete(ClientResponse.class);
	   
       if (response.getStatus() == 204) {
           return true;
       } else {
           return false;
       }
       
   }
   
   // ----------------------------- //
   
   public static void main(String[] args) {
	Servico servico = new Servico();
	
//	Teste listar()        
	for (VendasTO vto : servico.listar()) {
	  System.out.println("Vendas " + vto.getDescricao());
  }
	
	
	}
   
   
   
}
