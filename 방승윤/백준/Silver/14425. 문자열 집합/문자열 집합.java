import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arrayList.add(br.readLine());
        }

        int cnt = 0;

        for (int i = 0; i < M; i++) {
            if (arrayList.contains(br.readLine())) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}