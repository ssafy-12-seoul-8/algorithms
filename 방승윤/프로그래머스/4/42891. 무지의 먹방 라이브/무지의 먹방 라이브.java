import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        int answer = -1;
        int[] sorted_times = food_times.clone();
        Arrays.sort(sorted_times);
        int remain = food_times.length;
        int prev = 0;

        one: for (int i = 0; i < food_times.length; i++) {
            if (k < (long) (sorted_times[i] - prev) * remain) {
                long mod = k % remain;

                for (int j = 0; j < food_times.length; j++) {
                    if (food_times[j] > prev) {
                        if (mod == 0) {
                            return j + 1;
                        }

                        mod--;
                    }
                }
            }

            k -= (long) (sorted_times[i] - prev) * remain--;
            prev = sorted_times[i];

            if (k == 0) {
                for (int j = 0; j < food_times.length; j++) {
                    if (food_times[j] > prev) {
                        return j + 1;
                    }
                }
            }
        }

        return answer;
    }
}