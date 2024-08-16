import java.io.*;
import java.util.*;

class Solution {
	static class MaxHeap {
		int[] heap = new int[100001];
		int heapSize = 0;
		
		void swap(int i, int j) {
			int temp = heap[i];
			heap[i] = heap[j];
			heap[j] = temp;
		}
		
		void addData(int data) {
			heap[++heapSize] = data;
			
			int parent = heapSize / 2;
			int child = heapSize;
			
			while(child != 1 && heap[parent] < heap[child]) {
				swap(parent, child);

				child = parent;
				parent = child / 2;
			}
		}
		
		int popData() {
			if(heapSize == 0) {
				return -1;
			} else {
				int popItem = heap[1];
				
				heap[1] = heap[heapSize--];
				
				int parent = 1;
				int child = parent * 2;
				
				if(child + 1 <= heapSize && heap[child] < heap[child + 1]) {
					child++;
				}
				
				while(child <= heapSize && heap[parent] < heap[child]) {
					swap(parent, child);
					
					parent = child;
					child = parent * 2;
					if(child + 1 <= heapSize && heap[child] < heap[child + 1]) {
						child++;
					}
				}
				
				return popItem;
			}
		}
	}
	
	public static void main(String args[]) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int test_case = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < test_case; i++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			MaxHeap maxheap = new MaxHeap();
			
			sb.append("#").append(i + 1);
			
			for(int j = 0; j < N; j++) {
				String[] operatorArray = br.readLine().split(" ");
				
				if(operatorArray[0].equals("1")) {
					maxheap.addData(Integer.parseInt(operatorArray[1]));
				} else {
					sb.append(" ").append(maxheap.popData());
				}
			}
			System.out.println(sb);
		}
	}	
}
