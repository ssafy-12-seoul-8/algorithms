import java.io.*;
import java.util.*;

class Solution {
	static int resultNumber;
	static int resultSize;
	
	public static void main(String args[]) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < test_case; i++) {
			resultNumber = 0;
			resultSize = 1;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer edgeTokens = new StringTokenizer(br.readLine());
			int vertextN = Integer.parseInt(st.nextToken());
			int edgeN = Integer.parseInt(st.nextToken());
			int requestFirstIndex = Integer.parseInt(st.nextToken());
			int requestSecondIndex = Integer.parseInt(st.nextToken());
			
			int[][] edgeArray = new int[edgeN][2];
			int[] requestFirstParentArray = new int [vertextN - 1];
			int[] requestSecondParentArray = new int [vertextN - 1];
			int firstSize = 0;
			int secondSize = 0;
			
			for(int j = 0; j < edgeN; j++) {
				edgeArray[j][0] = Integer.parseInt(edgeTokens.nextToken());
				edgeArray[j][1] = Integer.parseInt(edgeTokens.nextToken());
			}
			
			int childIndex = requestFirstIndex;
			
			while(childIndex != 1) {
				for(int j = 0; j < edgeN; j++) {
					if(edgeArray[j][1] == childIndex) {
						requestFirstParentArray[firstSize++] = edgeArray[j][0];
						childIndex = edgeArray[j][0];
					}
				}
			}

			childIndex = requestSecondIndex;
			
			while(childIndex != 1) {
				for(int j = 0; j < edgeN; j++) {
					if(edgeArray[j][1] == childIndex) {
						requestSecondParentArray[secondSize++] = edgeArray[j][0];
						childIndex = edgeArray[j][0];
					}
				}
			}
			
			while(firstSize != 0 && secondSize != 0 && requestFirstParentArray[firstSize - 1] == requestSecondParentArray[secondSize - 1]) {
				resultNumber = requestFirstParentArray[firstSize - 1];
				firstSize--;
				secondSize--;
			}
			
			calculateHeight(edgeArray, resultNumber);
			
			System.out.printf("#%d %d %d\n", i + 1, resultNumber, resultSize);
		}
	}	
	
	static void calculateHeight(int[][] tree, int vertex) {
		for(int i = 0; i < tree.length; i++) {
			if(tree[i][0] == vertex) {
				resultSize++;
				calculateHeight(tree, tree[i][1]);
			}
		}
	}
	
}