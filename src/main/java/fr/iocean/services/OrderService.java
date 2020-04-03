package fr.iocean.services;

import javax.enterprise.context.ApplicationScoped;

import fr.iocean.beans.Order;

@ApplicationScoped
public class OrderService extends AbstractEntityService<Order> {

	@Override
	protected Class<Order> getEntityClass() {
		return Order.class;
	}

}
