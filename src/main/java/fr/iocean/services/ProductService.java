package fr.iocean.services;

import javax.enterprise.context.ApplicationScoped;

import fr.iocean.beans.Product;

@ApplicationScoped
public class ProductService extends AbstractEntityService<Product> {

	@Override
	protected Class<Product> getEntityClass() {
		return Product.class;
	}
}
