import java.io.*;
import java.util.*;

public class read_char {
	public static void main(String[] args) throws IOException {
		char ch;
		System.out.println("输入一个字符：");
		ch = (char)System.in.read();
		System.out.println(ch);
	}
}
