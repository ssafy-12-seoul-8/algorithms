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
        int kind = 0;
        int left = 0;
        int max = 0;

        for (int i = 0; i < len; i++) {
            cnt[cha[i]]++;
            if (cnt[cha[i]] == 1) {
                kind++;
            }

            while (kind > n) {
                cnt[cha[left]]--;
                if (cnt[cha[left]] == 0) {
                    kind--;
                }
                left++;
            }

            max = Math.max(max, i - left + 1);
        }

        System.out.println(max);
    }
}
