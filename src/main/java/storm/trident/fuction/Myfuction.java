package storm.trident.fuction;

import org.apache.storm.trident.operation.BaseFunction;
import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.tuple.TridentTuple;
import org.apache.storm.tuple.Values;

import storm.trident.entry.MyData;


/**
 * <p>Description:  </p>
 * <p>Date: 2018年12月5日</p>
 * @author dingd
 *
 */
public class Myfuction extends BaseFunction{
	private static final long serialVersionUID = 7627228173313973112L;

	public void execute(TridentTuple tuple, TridentCollector collector) {
		String input = tuple.getString(0);
		String[] strings = input.split(",");
		MyData myData = new MyData();
		myData.setTag(strings[0]);
		myData.setK(strings[1]);
		myData.setT(strings[2]);
		myData.setV(Long.valueOf(strings[3].trim()));
		collector.emit(new Values(myData.getTag(), myData.getT(), myData));
	}

}
