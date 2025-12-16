class Solution {
    public int solution(int[][] board, int[][] skills) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int[][] prefixSum = new int[N][M];
        
        for (int[] skill : skills) {
            int type = skill[0];
            int r1 = skill[1];
            int c1 = skill[2];
            int r2 = skill[3];
            int c2 = skill[4];
            int degree = skill[5];
            
            prefixSum[r1][c1] += type == 1 ? -degree : degree;
            
            if (r2 != N - 1) {
                prefixSum[r2 + 1][c1] -= type == 1 ? -degree : degree;
            }
            
            if (c2 != M - 1) {
                prefixSum[r1][c2 + 1] -= type == 1 ? -degree : degree;
            }
            
            if (r2 != N - 1 && c2 != M - 1) {
                prefixSum[r2 + 1][c2 + 1] += type == 1 ? -degree : degree;
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < M; j++) {
                prefixSum[i][j] += prefixSum[i][j - 1];
            }
        }
        
        for (int j = 0; j < M; j++) {
            for (int i = 1; i < N; i++) {
                prefixSum[i][j] += prefixSum[i - 1][j];
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                answer += board[i][j] + prefixSum[i][j] > 0 ? 1 : 0;
            }
        }
        
        return answer;
    }
}