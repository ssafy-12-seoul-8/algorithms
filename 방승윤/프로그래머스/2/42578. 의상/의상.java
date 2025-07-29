import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String[] cloth : clothes) {
            hashMap.put(cloth[1], hashMap.getOrDefault(cloth[1], 0) + 1);
        }

        for (int cnt : hashMap.values()) {
            answer *= cnt + 1;
        }

        return answer - 1;
    }
}
