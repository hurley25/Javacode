import java.io.*;

public class ReadFile {
	public static void main(String[] args) throws IOException {
		FileInputStream fin = null;
		int i;
		try {
			fin = new FileInputStream(args[0]);
			while ((i = fin.read()) != -1) {
				System.out.print((char)i);
			}
		} catch(FileNotFoundException e) {
			System.err.println("file not found");
			System.exit(-1);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("Useage: java ReadFile filename");
			System.exit(-2);
		} catch(IOException e) {
			System.err.println("Read File Error");
			System.exit(-3);
		} finally {
			fin.close();
		}
	}
}
