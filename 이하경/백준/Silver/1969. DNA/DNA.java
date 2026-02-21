import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dna = new int[n];
        int[][] count = new int[m][4];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int tmp = 0;
            for (int j = 0; j < m; j++) {
                tmp *= 10;
                char nuc = str.charAt(j);

                if (nuc == 'A') {
                    count[j][0]++;
                } else if (nuc == 'C') {
                    tmp += 1;
                    count[j][1]++;
                } else if (nuc == 'G') {
                    tmp += 2;
                    count[j][2]++;
                } else {
                    tmp += 3;
                    count[j][3]++;
                }
            }
            dna[i] = tmp;
        }

        int dist = 0;
        for (int i = 0; i < m; i++) {
            int max = 0;
            int maxNuc = 0;

            for (int j = 0; j < 4; j++) {
                if (max < count[i][j]) {
                    max = count[i][j];
                    maxNuc = j;
                }
            }

            if (maxNuc == 0) {
                sb.append('A');
            } else if (maxNuc == 1) {
                sb.append('C');
            } else if (maxNuc == 2) {
                sb.append('G');
            } else {
                sb.append('T');
            }

            dist += (n - max);
        }

        sb.append("\n").append(dist);
        System.out.println(sb);
    }
}
