class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] existList = new boolean[10];
        
        for(int i = 0; i < numbers.length; i++){
            existList[numbers[i]] = true;
        }
        
        for(int i = 0; i < existList.length; i++){
            if(existList[i] == false){
                answer += i;
            }
        }
        
        return answer;
    }
}