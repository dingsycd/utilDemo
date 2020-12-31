package delayTask;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 类说明
 *
 * @author grl
 * @date 2019年12月16日 新建
 */
public class Order implements Delayed {
	private String orderShopNum;
	/**
	 * 1-普通活动 2-限时活动 3-拼购活动
	 */
	private int orderType;
	private long orderCreateTime;
	private long expTime;
	public Order(String orderShopNum, int orderType, Date createTime) {
		if (StringUtils.isNotBlank(orderShopNum)) {
			this.orderShopNum = orderShopNum.trim();
		}
		if (createTime == null) {
			this.orderCreateTime = System.currentTimeMillis();
		} else {
			this.orderCreateTime = createTime.getTime();
		}
		this.orderType = orderType;
//		if (orderType == 2) {
//			this.expTime = TimeUnit.MILLISECONDS.convert(1, TimeUnit.MINUTES)
//					+ createTime.getTime();
//		}if(orderType == 3){
//			this.expTime = TimeUnit.MILLISECONDS.convert(2, TimeUnit.MINUTES)
//					+ createTime.getTime();
//		} else {
//			this.expTime = TimeUnit.MILLISECONDS.convert(3, TimeUnit.DAYS)
//					+ createTime.getTime();
//		}
		if (orderType == 2) {
			this.expTime = TimeUnit.MILLISECONDS.convert(1, TimeUnit.MINUTES);
		}if(orderType == 3){
			this.expTime = TimeUnit.MILLISECONDS.convert(2, TimeUnit.MINUTES);
		} else {
			this.expTime = TimeUnit.MILLISECONDS.convert(3, TimeUnit.DAYS);
		}
	}
	public String getOrderShopNum() {
		return orderShopNum;
	}
	public long getOrderCreateTime() {
		return orderCreateTime;
	}
	public long getExpTime() {
		return expTime;
	}
	public int getOrderType() {
		return orderType;
	}
	@Override
	public int compareTo(Delayed o) {
		return Long.valueOf(this.expTime).compareTo(Long.valueOf(((Order) o).expTime));
	}
	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(this.expTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}

}