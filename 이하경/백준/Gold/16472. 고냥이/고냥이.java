import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int len = s.length();
        int[] cha = new int[len];
        for (int i = 0; i < len; i++) {
            cha[i] = s.charAt(i) - 'a';
        }

        int[] cnt = new int[26];
        int count = 0;
        int max = 0;
        int l = 0;
        int r = -1;
        while (r < len - 1) {
            while (r < len - 1 && count < n) {
                r++;
                cnt[cha[r]]++;
                if (cnt[cha[r]] == 1) {
                    count++;
                }
                max = Math.max(max, r - l + 1);
            }

            while (r < len - 1 && count == n && cnt[cha[r + 1]] != 0) {
                r++;
                cnt[cha[r]]++;
                max = Math.max(max, r - l + 1);
            }

            while (count == n) {
                cnt[cha[l]]--;
                if (cnt[cha[l]] == 0) {
                    count--;
                }
                l++;
            }
        }

        System.out.println(max);
    }
}
