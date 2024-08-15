import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int[][] tree;
	static int[] cnt;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            
            StringBuilder sb = new StringBuilder();
            int V = sc.nextInt();
            int E = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            tree = new int[V + 1][3];
            cnt = new int[V + 1];
            
            for (int i = 0; i < E; i ++) {
            	int parent = sc.nextInt();
            	int child = sc.nextInt();
            	tree[child][0] = parent;
            	if (tree[parent][1] == 0) {
            		tree[parent][1] = child;
            	} else {
            		tree[parent][2] = child;
            	}
            }
            
            
            findParent(a);
            int answer = findParent(b);
            sb.append("#").append(test_case).append(" ").append(answer).append(" ").append(treeSize(answer));
            System.out.println(sb);
            
        }
        
    }
    
    static int findParent (int childNum) {
    	if (cnt[childNum] == 1) {
    		return childNum;
    	}
    	cnt[childNum]++;
    	return findParent(tree[childNum][0]);
    }
    
    static int treeSize (int parentNum) {
    	if (parentNum == 0) {
    		return 0;
    	}
    	if (tree[parentNum][1] == 0) {
    		return 1;
    	}
    	return treeSize(tree[parentNum][1]) + treeSize(tree[parentNum][2]) + 1;
    }
    
}