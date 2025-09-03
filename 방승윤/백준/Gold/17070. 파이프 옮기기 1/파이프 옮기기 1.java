import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][][] house = new int[N][N][4];
        house[0][1][1] = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                house[i][j][0] = Integer.parseInt(st.nextToken());

                if (i == 0 && (j == 0 || j == 1) || house[i][j][0] == 1) {
                    continue;
                }

                if (j - 1 >= 0 && house[i][j - 1][0] == 0) {
                    house[i][j][1] = house[i][j - 1][1] + house[i][j - 1][2];
                }

                if (i - 1 >= 0 && house[i - 1][j][0] == 0) {
                    house[i][j][3] = house[i - 1][j][2] + house[i - 1][j][3];
                }

                if (i - 1 >= 0 && j - 1 >= 0 && house[i][j - 1][0] == 0 && house[i - 1][j - 1][0] == 0 && house[i - 1][j][0] == 0 ) {
                    house[i][j][2] = house[i - 1][j - 1][1] + house[i - 1][j - 1][2] + house[i - 1][j - 1][3];
                }
            }
        }

        System.out.println(house[N - 1][N - 1][1] + house[N - 1][N - 1][2] + house[N - 1][N - 1][3]);
    }
}