/*
 * 归并排序的实现
 *
 * 时间：2013/5/27
 *
 */

public class Merge
{
	private static Comparable[] aux;

	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		// 将数组 a[lo..hi] 排序
		if (hi <= lo) {
			return;
		}
		int mid = lo + (hi - lo) / 2;   // (lo & hi) + ((lo ^ hi) >> 1)
		sort(a, lo, mid); 		// 左半边排序
		sort(a, mid + 1, hi); 		// 右半边排序
		merge(a, lo, mid, hi); 		// 归并结果
	}

	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid + 1, hi);

		// 将 a[lo..mid] 和 a[mid+1..hi] 归并
		int i = lo, j = mid + 1;
		
		// 将 a[lo..hi] 复制到 aux[lo..hi]
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
	
		// 归并回到 a[lo..hi]
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if (less(aux[j], aux[i])) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i-1])) {
				return false;
			}
		}
		return true;
	}
	private static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++) {
			if (less(a[i], a[i-1])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] a = In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}


