package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.VendasBO;
import br.com.fiap.to.VendasTO;

@Path("/venda")
public class Service {
	
	private VendasBO vendaBO = new VendasBO();
	
	//Retornar lista de vendas
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 public VendasTO[] buscar() {

		 return vendaBO.listagem();
	  }
	 
	 //Buscar por ID
	 @GET
	 @Path("/{id}")
     @Produces(MediaType.APPLICATION_JSON)
	 public VendasTO buscar(@PathParam("id") int cod) {
		 return vendaBO.listagem(cod);
	 }
	 
	 //Cadastrar venda
	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 public Response cadastrar(VendasTO venda, @Context UriInfo uriInfo) {
	        vendaBO.cadastrar(venda);
	        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
	        builder.path(Integer.toString(venda.getCodigo()));
	        return Response.created(builder.build()).build();
	 }
	 
	 //Atualizar venda
	 @PUT
	 @Path("/{id}")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public Response atualizar(VendasTO venda, @PathParam("id") int cod) {
	        venda.setCodigo(cod);
	        vendaBO.atualizar(venda);
	        return Response.ok().build();
	 }
	 
	 @DELETE
	 @Path("/{id}")
	 public void remover(@PathParam("id") int cod) {
	      vendaBO.excluir(cod);
	 }

}
