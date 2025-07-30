class Solution {
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[][] logic = new int[2][N + 1];

        for (int stage : stages) {
            logic[0][stage - 1]++;
        }

        logic[1][N] = logic[0][N];

        for (int i = N - 1; i >= 0; i--) {
            logic[1][i] = logic[1][i + 1] + logic[0][i];
        }

        double[] failure = new double[N];

        for (int i = 0; i < N; i++) {
            failure[i] = (double) logic[0][i] / logic[1][i];
        }

        int[] rank = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (failure[i] < failure[j]) {
                    rank[i]++;
                } else {
                    rank[j]++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            answer[rank[i]] = i + 1;
        }

        return answer;
    }
}