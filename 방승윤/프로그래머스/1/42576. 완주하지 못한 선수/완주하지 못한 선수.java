import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

        for (String c : completion) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for (String p : participant) {
            if (!hashMap.containsKey(p)) {
                return p;
            }

            if (hashMap.get(p) == 0) {
                return p;
            }

            hashMap.replace(p, hashMap.get(p) - 1);
        }

        return "";
    }
}