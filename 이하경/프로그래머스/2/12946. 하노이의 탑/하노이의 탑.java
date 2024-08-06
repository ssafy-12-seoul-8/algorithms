import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[][] solution(int n) {
        List<int[]> res = hanoi(n, 1, 3); 
        
        int[][] answer = new int[res.size()][];
        res.toArray(answer);
        return answer;
    }
    
    // 현재높이, 시작점, 옮길지점
    public List<int[]> hanoi(int n, int start, int end){
        List<int[]> list = new ArrayList<>();
        if (n == 1){
            list.add(new int[]{ start, end});
        } else {
            int left = 6 - start - end;
            list.addAll(hanoi(n - 1, start, left));
            list.add(new int[]{ start, end });
            list.addAll(hanoi(n - 1, left, end));
        }
        return list;
    }
}