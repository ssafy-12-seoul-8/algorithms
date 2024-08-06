class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int value = left; value <= right; value++){
            int count = 0;
            
            for(int i = 1; i <= value; i++){
                if(value % i == 0){
                    count++;
                }
            }
            if(count % 2 == 0){
                answer += value;
            }
            else{
                answer -= value;
            }
        }
        return answer;
    }
}