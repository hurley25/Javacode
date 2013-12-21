import java.lang.*;

class PrintNum extends Thread {
	public void run() {
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
	}
}

class PrintChar implements Runnable {
	public void run() {
		System.out.println("a");
		System.out.println("b");
		System.out.println("c");
	}
}

public class print {
	public static void main(String[] args) {
		PrintNum printNum = new PrintNum();
		Thread printChar = new Thread(new PrintChar());
		
		printNum.start();
		printChar.start();
	}
}
