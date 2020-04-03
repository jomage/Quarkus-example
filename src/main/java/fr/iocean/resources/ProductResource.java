package fr.iocean.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.iocean.beans.Product;
import fr.iocean.services.ProductService;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
	
	@Inject
	ProductService service;

    @GET
    public List<Product> list() {
        return service.listAll();
    }
    
    @GET
    @Path("/createone")
    public Product createOne() {
    	Product p = new Product();
    	p.setName("test " + Math.random()*100);
    	p.setUnitPrice(Math.random()*500);
    	service.createEntity(p);
    	return p;
    }
    
    @POST
    public Product add(Product product) {
    	return service.createEntity(product);
    }
}