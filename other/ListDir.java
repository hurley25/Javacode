import java.io.*;

public class ListDir {
	public static void main(String[] args) throws IOException {
		File myDir = new File("/home/hurley/Program/Java/exam/mydir");
		if (!myDir.exists()) {
			myDir.mkdir();
		}
		File myFile = new File(myDir, "myfile.txt");
		if (!myFile.exists()) {
			myFile.createNewFile();
		}
		listDir(myDir);
	}

	static void listDir(File dir) {
		File[] listFile = dir.listFiles();
		String info = "目录：" + dir.getName() + "{ ";
		for (File file : listFile) {
			info += file.getName() + " ";
		}
		info += "}";
		System.out.println(info);
		for (File file : listFile) {
			if (file.isFile()) {
				printFileInfo(file);
			} else {
				listDir(file);
			}
		}
	}

	static void printFileInfo(File file) {
		System.out.println("文件名： " + file.getName());
		System.out.println("文件父路径： " + file.getParent());
		System.out.println("文件可读？：" + file.canRead());
		System.out.println("文件长度： " + file.length() + " :字节");
	}
}
