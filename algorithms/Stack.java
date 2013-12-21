/*
 * 下压栈（链表实现）
 *
 *  2013/4/18
 *
 */

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	private class Node {
		Item item;
		Node next;
	}

	private Node first; 	// 栈顶
	private int N; 		// 元素数量

	public boolean isEmpty() {
		return (N == 0);
	}
	public int size() {
		return N;
	}

	public void push(Item item) {
		Node old_first = first;
		first = new Node();
		first.item = item;
		first.next = old_first;
		N++;
	}
	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;

		return item;
	}

	public Iterator<Item> iterator() {
		return (new ListIterator());
	}
	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() {
			return (current != null);
		}
		public Item next() {
			Item item = current.item;
			current = current.next;

			return item;
		}
		public void remove() {
		}
	}

	public static void main(String[] args) {
		Stack<String> stack = new Stack();

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
