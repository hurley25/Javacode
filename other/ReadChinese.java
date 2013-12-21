import java.io.*;

public class ReadChinese {
	public static void main(String[] args) {
		String str = "白日依山尽\n";
		char[] ch = str.toCharArray();
		FileWriter fw = null;
		FileReader fr = null;
		try {
			fw = new FileWriter("登鹳雀楼.txt");
			fw.write(ch);
			fw.write("黄河入海流\n");
			fw.write("欲穷千里目\n");
			fw.write("更上一层楼\n");
			fw.close();
		} catch(IOException e) {
			System.err.println("IOEcption");
			System.exit(-1);
		}
		try {
			fr = new FileReader("登鹳雀楼.txt");
			int i;
			while ((i = fr.read()) != -1) {
				System.out.print((char)i);
			}
			System.out.println();
			fr.close();
		} catch(FileNotFoundException e) {
			System.err.println("File not Found");
			System.exit(-1);
		} catch(IOException e) {
			System.err.println("IOEcption");
			System.exit(-3);
		}
	}
}
