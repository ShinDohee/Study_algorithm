package hackerrank_30p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution_Day7_Arrays {

	static ArrayList<Integer> reverseArray(int[] a) {

		ArrayList<Integer> emp = new ArrayList<Integer>();

		for (int i : a) {
			emp.add(i);
		}

		Collections.reverse(emp);

		return emp;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		ArrayList<Integer> emp = reverseArray(arr);
		for (int i = 0; i < emp.size(); i++) {
			 System.out.print(emp.get(i)+" ");
		}
		

		scanner.close();
	}
}
