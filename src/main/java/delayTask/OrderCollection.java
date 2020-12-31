package delayTask;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * 类说明
 *
 */
public class OrderCollection {
	/**
	 * 订单管理集合
	 */
	private static DelayQueue<Order> orderList = new DelayQueue<Order>();
	private OrderCollection() {
	}
	/**
	 * 获取订单集合
	 * @author grl
	 * @return
	 */
	protected static DelayQueue getOrderCollection() {
		return orderList;
	}
	/**
	 * 向集合中添加订单
	 *
	 * @author grl
	 * @param order
	 * @return
	 */
	public static boolean add(Order order) {
		boolean flag = false;
		if (order != null && StringUtils.isNotBlank(order.getOrderShopNum())) {
			flag = orderList.offer(order);
		}
		return flag;
	}
	/**
	 * 从集合中删除订单
	 *
	 * @author grl
	 * @param orderShopNum
	 * @return
	 */
	public static boolean remove(String orderShopNum) {
		boolean flag = false;
		Order thisOrder = null;
		if (StringUtils.isNotBlank(orderShopNum)) {
			orderShopNum = orderShopNum.trim();
			for (Order order : orderList) {
				String orderNum = order.getOrderShopNum();
				if (orderNum.equals(orderShopNum)) {
					thisOrder = order;
				}
			}
			if (thisOrder != null) {
				flag = orderList.remove(thisOrder);
			}
		}
		return flag;
	}
	/**
	 * 获取订单的过期剩余时间
	 *
	 * @author grl
	 * @param orderShopNum
	 * @return -1 已经过期
	 */
	public static long getDelay(String orderShopNum) {
		long time = -1;
		if (StringUtils.isNotBlank(orderShopNum)) {
			orderShopNum = orderShopNum.trim();
			for (Order order : orderList) {
				String orderNum = order.getOrderShopNum();
				if (orderNum.equals(orderShopNum)) {
					time = order.getDelay(TimeUnit.MILLISECONDS);
					if(time<5000) {
						time = -1;
					}
				}
			}
		}
		return time;
	}
}