package storm.trident.aggregator;

import java.util.Map;

import org.apache.storm.trident.operation.Aggregator;
import org.apache.storm.trident.operation.BaseAggregator;
import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.operation.TridentOperationContext;
import org.apache.storm.trident.planner.processor.AggregateProcessor;
import org.apache.storm.trident.tuple.TridentTuple;
import org.apache.storm.tuple.Values;

import storm.trident.entry.MyData;

/**
 * <p>Description:  </p>
 * <p>Date: 2018年12月5日</p>
 * @author dingd
 *
 */
public class Testagg extends BaseAggregator<MyData>{
	static final long serialVersionUID = -3506989674120035631L;

	public MyData init(Object batchId, TridentCollector collector) {
		return new MyData();
	}

	public void aggregate(MyData val, TridentTuple tuple, TridentCollector collector) {
		System.out.println("tuple---------" + tuple);
		System.out.println("tupleValue----" + tuple.getValues().toString());
		System.out.println("tuple(0)------" + tuple.getValue(0));
		System.out.println("tuple(1)------" + tuple.getValue(1));
		System.out.println("tuple(2)------" + tuple.getValue(2));
		MyData myData = (MyData) tuple.getValue(2);
		System.out.println(myData);
	}

	public void complete(MyData val, TridentCollector collector) {
		collector.emit(new Values(val));
		
	}

}
