import java.io.*;

public class WriteFile {
	public static void main(String[] args) {
		int i;
		try {
			FileOutputStream fout = new FileOutputStream("write.txt");
			System.out.println("输入点什么... 以 # 结束");
			while ((i = System.in.read()) != '#') {
				fout.write(i);
			}
			fout.close();
		} catch (FileNotFoundException e) {
			System.err.println("文件没有找到");
			System.exit(-1);
		} catch (IOException e) {
			System.err.println("IO Error");
			System.exit(-2);
		}
	}
}
