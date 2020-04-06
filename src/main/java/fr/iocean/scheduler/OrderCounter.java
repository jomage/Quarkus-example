package fr.iocean.scheduler;

import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import fr.iocean.filters.LoggingFilter;
import fr.iocean.services.OrderService;
import io.quarkus.scheduler.Scheduled;
import io.quarkus.scheduler.ScheduledExecution;

/**
 * Simple class that execute a scheduled execution that counts the number of
 * orders in DB.
 * @author jordi
 *
 */
@ApplicationScoped
public class OrderCounter {
	
	private static final Logger LOG = Logger.getLogger(LoggingFilter.class);
	private AtomicInteger counter = new AtomicInteger();
	
	@Inject
	private OrderService service;
	
	public int get() {
		return counter.get();
	}
	
	@Scheduled(every="40s")
	void cronJob(ScheduledExecution execution) {
		LOG.infof("Current total number of orders = %s", service.count());
	}
}
