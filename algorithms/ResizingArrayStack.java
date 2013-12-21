/*
 * 下压（LIFO）栈（动态调整数组实现）
 *
 *  2013/4/18
 *
 */

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
	private Item[] array = (Item[]) new Object[1]; 	// 栈元素
	private int N = 0; 				// 元素数量

	public boolean isEmpty() {
		return (N == 0);
	}
	public int size() {
		return N;
	}
	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = array[i];
		}
		array = temp;
	}
	public void push(Item item) {
		if (N == array.length) {
			resize(2 * array.length);
		}
		array[N++] = item;
	}
	public Item pop() {
		Item item = array[--N];
		array[N] = null; 	// 避免对象游离
		if (N > 0 && N == array.length / 4) {
			resize(array.length / 2);
		}

		return item;
	}

	public Iterator<Item> iterator() {
		return (new ReverArrayIterator());
	}
	private class ReverArrayIterator implements Iterator<Item> {
		private int i = N;
		public boolean hasNext() {
			return (i > 0);
		}

		public Item next() {
			return array[--i];
		}
		public void remove() {
		}
	}

	public static void main(String[] args) {
		ResizingArrayStack<String> stack = new ResizingArrayStack();

		stack.push("Hello1");
		stack.push("Hello2");
		stack.push("Hello3");
		stack.push("Hello4");
		stack.push("Hello5");
		
		for (String str : stack) {
			System.out.println(str);
		}

		while (stack.size() != 0) {
			System.out.println(stack.pop());
		}
	}
}
