import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        boolean reverse = false;
        int l = 0;
        int r = t.length() - 1;
        while (r - l >= s.length()) {
            char last = reverse ? t.charAt(l) : t.charAt(r);

            if (reverse) {
                l++;
            } else {
                r--;
            }

            if (last == 'B') {
                reverse = !reverse;
            }
        }

        boolean possible = true;
        if (reverse) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(r - i)) {
                    possible = false;
                    break;
                }
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(l + i)) {
                    possible = false;
                    break;
                }
            }
        }

        System.out.println(possible ? 1 : 0);
    }
}
