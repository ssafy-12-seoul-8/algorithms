class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int current = n;
        int remain = 0;
        
        while(current >= a){
            int getFrom = (current / a) * b;
            
            remain = current % a;
            answer += getFrom;
            current = getFrom + remain;
        }
        return answer;
    }
}