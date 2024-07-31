class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {};
        answer = new int[2];
        
        numer1 *= denom2;
        numer2 *= denom1;
        numer1 += numer2;
        denom1 *= denom2;
        int max;
        
        if (denom1 >= numer1) {
            max = denom1;
        } else {
            max = numer1;
        }
        
        for (int i = max; i >= 2; i--) {
            if (denom1 % i == 0 && numer1 % i == 0) {
                denom1 /= i;
                numer1 /= i;
            }
        }
        
        answer[0] = numer1;
        answer[1] = denom1;
        
        return answer;
    }
}