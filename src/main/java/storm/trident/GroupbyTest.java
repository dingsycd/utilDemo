package storm.trident;


import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.generated.StormTopology;
import org.apache.storm.trident.TridentTopology;
import org.apache.storm.trident.testing.FixedBatchSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import storm.trident.aggregator.Testagg;
import storm.trident.fuction.Myfuction;
 
 
public class GroupbyTest {
	
    @SuppressWarnings("unchecked")
	public static StormTopology buildTopology() {
    	//FixedBatchSpout, 发射出两个字段，user与score, 一个batch中包括3个tuples
        FixedBatchSpout spout = new FixedBatchSpout(new Fields("data"), 3, 
        		new Values("1, 1, 1, 3"),
        		new Values("1, 1, 2, 3"), 
        		new Values("1, 2, 1, 3"),
        		new Values("1, 2, 2, 3"),
        		new Values("2, 1, 1, 3"),
        		new Values("2, 1, 2, 3"), 
        		new Values("2, 2, 1, 3"),
        		new Values("2, 2, 2, 3")
                );
        spout.setCycle(false);
        TridentTopology topology = new TridentTopology();
        topology.newStream("input", spout)
        		.parallelismHint(2)
        		.each(new Fields("data"), new Myfuction(), new Fields("tag", "t", "myData"))
        		.parallelismHint(5)
        		.groupBy(new Fields("tag", "t"))
        		.aggregate(new Testagg(), new Fields("result"))
        		;
        		
        return topology.build();
    }
    
    public static void main(String[] args) throws Exception {
        Config conf = new Config();
        LocalCluster local = new LocalCluster();  
        local.submitTopology("test-topology", conf, buildTopology()); 
    }
}

