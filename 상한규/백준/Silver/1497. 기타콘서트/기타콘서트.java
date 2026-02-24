import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static boolean[][] guitars;
    static boolean[] songs;
    static int maxSongs = 0;
    static int minGuitars = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        guitars = new boolean[N][M];
        songs = new boolean[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String playable = st.nextToken();

            for (int j = 0; j < M; j++) {
                if (playable.charAt(j) == 'Y') {
                    guitars[i][j] = true;
                }
            }
        }

        backtrack(0, 0);

        if (maxSongs == 0) { 
          System.out.println("-1");
        } else {
          System.out.println(minGuitars);
        }
    }

    static void backtrack(int idx, int count) {
        int currentSongs = 0;
        for (int i = 0; i < M; i++) {
            if (songs[i]) {
              currentSongs++;
            }
        }

        if (currentSongs > maxSongs) {
            maxSongs = currentSongs;
            minGuitars = count;
        } 
        else if (currentSongs == maxSongs && currentSongs > 0) {
            if (minGuitars == -1 || count < minGuitars) {
                minGuitars = count;
            }
        }

        if (idx == N) return;

        boolean[] temp = new boolean[M];
        for (int i = 0; i < M; i++) {
            if (guitars[idx][i] && !songs[i]) {
                songs[i] = true;
                temp[i] = true; 
            }
        }
        backtrack(idx + 1, count + 1);

        for (int i = 0; i < M; i++) {
            if (temp[i]) songs[i] = false;
        }

        backtrack(idx + 1, count);
    }
}