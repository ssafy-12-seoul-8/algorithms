import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();
        int[] minIdx = new int[Math.min(s1.length, s2.length) + 1]; // i번에 s1의 끝 인덱스를 저장
        Arrays.fill(minIdx, s1.length);
        minIdx[0] = -1;

        for (char c : s2) {
            for (int i = minIdx.length - 2; i >= 0; i--) { // 길이
                for (int j = minIdx[i] + 1; j < minIdx[i + 1]; j++) { // 다음인덱스보다 크면 볼필요 x
                    if (s1[j] == c) {
                        minIdx[i + 1] = j;
                        break;
                    }
                }
            }
        }

        for (int i = minIdx.length - 1; i >= 0; i--) {
            if (minIdx[i] < s1.length) {
                System.out.println(i);
                break;
            }
        }

    }
}
