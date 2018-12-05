package storm.trident.aggregator;

import org.apache.storm.trident.operation.CombinerAggregator;
import org.apache.storm.trident.tuple.TridentTuple;

import storm.trident.entry.MyData;

/**
 * <p>Description:  </p>
 * <p>Date: 2018年12月5日</p>
 * @author dingd
 *
 */
public class MyAggregator implements CombinerAggregator<MyData>{
	private static final long serialVersionUID = -230911137008093393L;

	public MyData init(TridentTuple tuple) {
		System.out.println("tuple---------" + tuple);
		System.out.println("tupleValue----" + tuple.getValues().toString());
		System.out.println("tuple(0)------" + tuple.getValue(0));
		System.out.println("tuple(1)------" + tuple.getValue(1));
		System.out.println("tuple(2)------" + tuple.getValue(2));
		MyData myData = (MyData) tuple.getValue(2);
		return myData;
	}

	public MyData combine(MyData val1, MyData val2) {
		if (val1 != null) {
			val2.setV(val1.getV() + val2.getV());
		}
		System.out.println(val2);
		return val2;
	}

	public MyData zero() {
		// TODO Auto-generated method stub
		return null;
	}

}
