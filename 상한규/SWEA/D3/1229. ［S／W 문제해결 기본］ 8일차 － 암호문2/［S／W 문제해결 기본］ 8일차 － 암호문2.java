import java.io.*;
import java.util.*;

class Node {
	int data;
	Node link;
}

class LinkedList {
	Node head;
	int size;
	
	LinkedList () {
		head = new Node();
	}
	
	void addData(int i, int data) {
		if(i < 0 || i > size) {
			return;
		}
		Node newNode = new Node();
		newNode.data = data;
		
		Node curr = head;
		
		for(int j = 0; j < i; j++) {
			curr = curr.link;
		}
		
		newNode.link = curr.link;
		curr.link = newNode;
		
		size++;
	}

	void removeData(int i) {
		if(i < 0 || i >= size) {
			return;
		}
		
		size--;
		
		Node curr = head;
		
		for(int k = 0; k < i; k++) {
			curr = curr.link;
		}
		curr.link = curr.link.link;
	}
	
	StringBuilder printTen() {
		StringBuilder sb = new StringBuilder();
		Node curr = head.link;
		
		for(int i = 0; i < 10; i++) {
			sb.append(" ").append(curr.data);
			curr = curr.link;
		}
		return sb;
	}
}

public class Solution {
	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = 10;
		
		
		for (int i = 0; i < test_case; i ++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			String cryptogram = br.readLine();
			String[] cryptogramList = cryptogram.split(" ");
			int commandNumber = Integer.parseInt(br.readLine());
			String commandString = br.readLine();
			LinkedList list = new LinkedList();
			
			for(int j = 0; j < N; j++) {
				list.addData(j, Integer.parseInt(cryptogramList[j]));
			}
			
			StringTokenizer st = new StringTokenizer(commandString);
			
			while(st.hasMoreTokens()) {
				String token = st.nextToken();
				if(token.equals("I")) {
					int index = Integer.parseInt(st.nextToken());
					int count = Integer.parseInt(st.nextToken());
					
					for(int j = 0; j < count; j++) {
						int value = Integer.parseInt(st.nextToken());
						list.addData(index + j, value);
					}
				} else if(token.equals("D")) {
					int index = Integer.parseInt(st.nextToken());
					int count = Integer.parseInt(st.nextToken());
					
					for(int j = 0; j < count; j++) {
						list.removeData(index);
					}
				}
			}
			
			sb.append("#").append(i + 1).append(list.printTen());
			
			System.out.println(sb);
		}
	}
}
