class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = {};
        answer = new int[num_list.length / n][n];

        int rowIdx = 0;
        int colIdx = 0;
        int cnt = 0;
        for (int num : num_list) {
            if (cnt % n == 0 && cnt != 0) {
                rowIdx++;
                colIdx = 0;
            }
            answer[rowIdx][colIdx] = num;
            cnt++;
            colIdx++;
        }
        return answer;
    }
}