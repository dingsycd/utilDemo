package storm.trident.entry;

import java.io.Serializable;

/**
 * <p>Description:  </p>
 * <p>Date: 2018年12月5日</p>
 * @author dingd
 *
 */
public class MyData implements Serializable{
	private static final long serialVersionUID = -8999381803359545426L;
	private String tag;
	private String k;
	private String t;
	private Long v;
	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public String getK() {
		return k;
	}
	
	public void setK(String k) {
		this.k = k;
	}
	
	public String getT() {
		return t;
	}
	
	public void setT(String t) {
		this.t = t;
	}
	
	public Long getV() {
		return v;
	}
	
	public void setV(Long v) {
		this.v = v;
	}

	@Override
	public String toString() {
		return tag + ", " + k + ", " + t + ", " + v; 
	}
}
