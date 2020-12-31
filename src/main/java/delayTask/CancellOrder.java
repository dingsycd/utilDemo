package delayTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CancellOrder {
	private static final Logger log = LoggerFactory.getLogger(CancellOrder.class);
	public static void main(String[] args) throws InterruptedException {
		Order order1 = new Order("任务1", 1, new Date());
		Order order2 = new Order("任务2", 2, new Date());
		Order order3 = new Order("任务3", 3, new Date());
		OrderCollection.add(order1);
		OrderCollection.add(order2);
		OrderCollection.add(order3);
		while (true) {
			System.out.println(OrderCollection.getDelay("任务1"));
			Thread.sleep(10000);
		}
	}
}
