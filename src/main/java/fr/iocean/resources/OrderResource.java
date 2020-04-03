package fr.iocean.resources;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.iocean.beans.Order;
import fr.iocean.beans.Product;
import fr.iocean.services.OrderService;
import fr.iocean.services.ProductService;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

	@Inject
	OrderService service;

	@Inject
	ProductService prodService;
	
    @GET
    public List<Order> list() {
        return service.listAll();
    }
    
    @GET
    @Path("/createone")
    public Order createOne() {
    	Order o = new Order();
    	o.setDateOrdered(Date.valueOf(LocalDate.now()));
    	o.setProductsOrdered(new ArrayList<Product>(prodService.listAll()));
    	o.setShippingAddress("35 rue gambetta 34000 Montpellier");
    	service.createEntity(o);
    	return o;
    }
    
    @POST
    public Order add(Order Order) {
    	return service.createEntity(Order);
    }

}
