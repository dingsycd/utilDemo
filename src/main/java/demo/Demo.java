package demo;
/**
 * <p>Description:  </p>
 * <p>Date: 2018年11月19日</p>
 * @author dingd
 *
 */
public class Demo {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println("a");
		System.out.println(11);
		System.out.println("11.20");
		System.out.println(get(3));
	}

	static boolean get(int n) {
		for (int i = 0; i < n; i++) {
			if(i == 3) return false;
			System.out.println(i);
		}
		return true;
	}
}
