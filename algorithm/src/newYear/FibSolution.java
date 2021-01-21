package newYear;
/**
 * 509. 斐波那契数列
 * 通常用 F(n) 表示，形成的序列成为 斐波那契数列。
 * 该数列由0 和 1 开始，后面的每一项数字都是前两项数字的和。
 * F(0) = 0;
 * F(1) = 1;
 * F(n) = F(n-1) + F(n-2), n>1;
 * 给出 n ，请计算 F(n)
 * @author dell
 *
 */
public class FibSolution {
	
	public int fib(int n) {
		if(n < 2) {
			return n;		
		}
		int p = 0;
		int q = 0;
		int r = 1;
		for(int i = 2; i <= n; ++i) {
			p = q;
			q = r;
			r = p+q;			
		}
		return r;
		
	}

}
