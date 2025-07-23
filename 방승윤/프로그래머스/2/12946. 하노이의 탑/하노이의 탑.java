class Solution {
    static int idx;
    static int[][] answer;
    
    public int[][] solution(int n) {
        answer = new int[(int) Math.pow(2, n) - 1][2];
        recur(n, 1, 2, 3);
        return answer;
    }
    
    public void recur(int n, int f, int s, int t) {
        if (n == 1) {
            answer[idx][0] = f;
            answer[idx][1] = t;
            idx++;
            return;
        }
        
        recur(n - 1, f, t, s);
        answer[idx][0] = f;
        answer[idx][1] = t;
        idx++;
        recur(n - 1, s, f, t);
    }
}