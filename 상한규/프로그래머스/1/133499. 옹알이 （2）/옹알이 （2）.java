class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] ableBabble = {"aya", "ye", "woo", "ma"};
        
        for(String text : babbling){
            char[] charArray = text.toCharArray();
            boolean flag = false;
            
            for(String babble : ableBabble){
                char[] babbleCharArray = babble.toCharArray();
                
                for(int charIndex = 0; charIndex <= charArray.length - babbleCharArray.length * 2; charIndex++){
                    if(charArray[charIndex] == (babbleCharArray[0])){
                        
                        for(int i = 0; i < babbleCharArray.length; i++){
                            if(charArray[charIndex + i] != babbleCharArray[i] || charArray[charIndex + i + babbleCharArray.length] != babbleCharArray[i] ){     
                                break;
                            }
                            else if(i == babbleCharArray.length - 1){
                                flag = true;    
                            }
                        }
                    }
                }  
            }
            if(flag != true){
                for(String babble : ableBabble){
                    text = text.replace(babble," ");
                }
                text = text.replaceAll(" ","");
                if(text.equals("")){
                    answer++;
                }
            }
        }
        return answer;
    }
}