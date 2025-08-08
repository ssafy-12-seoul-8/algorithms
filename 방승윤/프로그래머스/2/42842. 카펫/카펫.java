class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        one: for (int i = 0; i < 2500;i++) {
            for (int j = i; j < 5000; j++) {
                if ((i + j - 2) * 2 > brown) {
                    continue one;
                }
                
                if ((i + j - 2) * 2 == brown && (i - 2) * (j - 2) == yellow) {
                    answer = new int[] {j, i};
                }
            }
        }
        
        return answer;
    }
}