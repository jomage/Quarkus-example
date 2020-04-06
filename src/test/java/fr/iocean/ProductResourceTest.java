package fr.iocean;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import fr.iocean.beans.Product;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ProductResourceTest {

	@Test
	public void testListProducts() {
		given()
			.when().get("/products")
			.then()
				.statusCode(200);
	}
	
	@Test
	public void testCreateProduct() {
		Product p = new Product();
		p.setName("test product");
		p.setUnitPrice(20d);
		given()
			.when().post("/products", p)
	        .then()
	        	.statusCode(200)
	        	.body(is(p));
	}
}
