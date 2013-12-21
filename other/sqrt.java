import java.math.*;

class ThrowNumberException extends Exception {
	double value;
	ThrowNumberException(double value) {
		super("输入的数据小于0");
		this.value = value;
	}

	public String toString() {
		return "ThrowNumberException: 输入数值错误！" + value;
	}
}

public class sqrt {
	public double calcSqrt(double value) throws ThrowNumberException {
		if (value >= 0) {
			return Math.sqrt(value);
		} else {
			throw new ThrowNumberException(value);
		}
	}

	public static void main(String[] args) {
		sqrt calc = new sqrt();;
		try {
			System.out.println(calc.calcSqrt(2));
			System.out.println(calc.calcSqrt(-1));
		} catch (ThrowNumberException e) {
			System.out.println(e);
		} finally {
			System.out.println("结束异常处理");
		}
	}
}
