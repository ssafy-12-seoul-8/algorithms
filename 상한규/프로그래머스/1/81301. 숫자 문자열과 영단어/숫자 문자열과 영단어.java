import java.util.*;

class Solution {
    static Map<String, String> map = new HashMap<>();
    
    static{
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
    }
    
    public int solution(String s) {
        int answer = 0;

        for(String mapKey : map.keySet()){
            if(s.contains(mapKey)){
                s = s.replace(mapKey, map.get(mapKey));
            }
        }     
        
        answer = Integer.parseInt(s);
        return answer;
    }
}