package hackerrank_30p;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_Day23_BSTLevel_Orde_Traversal {

	private searchNode searchNode;

	static void levelOrder(searchNode root) {
		// Write your code here
		Queue<searchNode> q = new LinkedList();

		q.add(root);
		String result = "";

		while (!q.isEmpty()) {
			searchNode current = q.remove();
			result += " " + current.data;

			// 왼쪽이 먼저 있는지 확인 한 후 add
			if (current.left != null) {
				q.add(current.left);
			}

			if (current.right != null) {
				q.add(current.right);
			}
		}

		System.out.println(result.substring(1));
	}

	public static searchNode insert(searchNode root, int data) {
		if (root == null) {
			return new searchNode(data);
		} else {
			searchNode cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		searchNode root = null;
		while (T-- > 0) {
			int data = sc.nextInt();
			root = insert(root, data);
		}
		levelOrder(root);
	}
}
