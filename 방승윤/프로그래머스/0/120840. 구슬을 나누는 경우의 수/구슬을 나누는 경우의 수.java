class Solution {
    public int solution(int balls, int share) {
        int answer = 0;
        double temp1 = 1;
        double temp2 = 1;
        
        if (balls == share) {
            return 1;
        }
        
        for (int i = 0; i < balls - share; i++) {
            temp1 *= balls - i;
            temp2 *= balls - share - i;
        }
        
        answer = (int) (temp1 / temp2);
        
        return answer;
    }
}