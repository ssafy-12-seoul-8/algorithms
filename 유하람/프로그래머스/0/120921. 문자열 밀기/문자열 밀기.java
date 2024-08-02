

class Solution {
    public int solution(String B, String A) {
        int answer = -1;
        char[] charArr = B.toCharArray();
        int cnt = 0;
        int l = B.length();
        
        
        while(cnt<l){
            if(A.equals(B)){
                answer=cnt;
                break;
            }
            
            char temp = charArr[l-1];
            for(int i=l-1 ; i>0 ; i--){   
                charArr[i] =charArr[i-1];      
            }
            charArr[0]=temp;
            String ans = new String(charArr);
            cnt++;
            
            if(A.equals(ans)){
                answer=cnt;
                break;
            }
        }
        
        return answer;
    }
}