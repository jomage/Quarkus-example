package fr.iocean;

import static io.restassured.RestAssured.given;

import java.sql.Date;
import java.time.LocalDate;
import javax.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;
import fr.iocean.beans.Order;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class OrderResourceTest {

	@Test
	public void testListOrders() {
		given()
			.when().get("/orders")
			.then()
				.statusCode(200);
	}
	
	@Test
	public void testCreateProduct() {
		Order o = new Order();
		o.setShippingAddress("test order");
		o.setDateOrdered(Date.valueOf(LocalDate.now()));
		given()
			.body(o).contentType(MediaType.APPLICATION_JSON)
			.when().post("/orders")
	        .then()
	        	.statusCode(200);
//	        	.body(is());
	}
}
