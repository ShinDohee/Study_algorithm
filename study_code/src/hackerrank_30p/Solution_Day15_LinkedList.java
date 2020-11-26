package hackerrank_30p;

import java.util.Scanner;

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

public class Solution_Day15_LinkedList {
	public static  Node insert(Node head,int data) {
        //Complete this method
		Node node = new Node(data);
		Node currNode = head;
		
		if(head == null) {
			return node;
		}else {
			
			while(currNode.next!=null) {
				currNode= currNode.next;
			}
			currNode.next =node;
			return head;
			
		}
		
	}

	public static void display(Node head) {
		Node start = head;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Node head = null;
		int N = sc.nextInt();

		while (N-- > 0) {
			int ele = sc.nextInt();
			head = insert(head, ele);
		}
		display(head);
		sc.close();
	}
}
