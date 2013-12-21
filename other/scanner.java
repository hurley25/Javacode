import java.util.*;

public class scanner {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		System.out.println("输入一个整数");
		int num_int = reader.nextInt();
		System.out.println(num_int);
		System.out.println("输入一个浮点数");
		double num_double = reader.nextDouble();
		System.out.println(num_double);
		System.out.println("输入一个boolean数");
		boolean num_boolean = reader.nextBoolean();
		System.out.println(num_boolean);
		System.out.println("输入一个字符串");
		String str = reader.next();
		System.out.println(str);
	}
}
