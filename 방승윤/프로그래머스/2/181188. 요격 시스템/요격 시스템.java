import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        
        Arrays.sort(targets, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        
        int minE = targets[0][1];
        
        for (int i = 1; i < targets.length; i++) {
            if (targets[i][0] >= minE) {
                answer++;
                minE = targets[i][1];
            } else {
                minE = Math.min(minE, targets[i][1]);
            }
        }
        
        return answer;
    }
}