class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        
        for (int i = 1; i <= n - 4; i++) {
            for (int j = i + 1; j <= n - 3; j++) {
                for (int k = j + 1; k <= n - 2; k++) {
                    for (int l = k + 1; l <= n - 1; l++) {
                        one: for (int m = l + 1; m <= n; m++) {
                            int[] code = {i, j, k, l, m};
                            
                            for (int idx = 0; idx < q.length; idx++) {
                                int[] temp = q[idx];
                                int cnt = 0;
                                
                                for (int num : code) {
                                    for (int tempNum : temp) {
                                        if (num == tempNum) {
                                            cnt++;
                                            break;
                                        }
                                    }
                                }
                                
                                if (ans[idx] == cnt) {
                                    continue;
                                }
                                
                                continue one;
                            }
                            
                            answer++;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}