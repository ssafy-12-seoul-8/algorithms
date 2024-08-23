import java.util.*;

class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        String[] array = s.split("");
        array[0] = array[0].toUpperCase();
        
        for(int i = 1; i < array.length; i++) {
            if(array[i - 1].equals(" ")) {
                array[i] = array[i].toUpperCase();
            }
        }
        
        return Arrays.stream(array)
            .reduce("", (a, b) -> a + b);
    }
}