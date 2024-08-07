import java.util.*;

class Solution {
    List<int[]> result = new ArrayList<>();
    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        
        int[][] resultArr = new int[result.size()][];
        
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        
        return resultArr;
    }
    
    void hanoi(int n, int from, int to, int via) {
        if (n == 0) {
            return;
        }
       
        hanoi(n - 1, from, via, to);
        result.add(new int[] {from, to});
        hanoi(n - 1, via, to, from);
    }
}