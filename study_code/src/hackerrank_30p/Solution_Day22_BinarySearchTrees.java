package hackerrank_30p;

import java.util.Scanner;
class searchNode{
    searchNode left,right;
    int data;
    searchNode(int data){
        this.data=data;
        left=right=null;
    }
}
public class Solution_Day22_BinarySearchTrees {
	

	public static int getHeight(searchNode root){
      //Write your code here

		if(root == null) return -1;

        int leftDepth = getHeight(root.left);
        int rightDepth = getHeight(root.right);
        
        return Math.max(leftDepth,rightDepth)+1;

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
		System.out.println("debug");
		int height = getHeight(root);
		System.out.println(height);
	}
}
