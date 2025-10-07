import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[1000001];
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine() , " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int k = Integer.parseInt(br.readLine());

        for (int i : arr) {
            cnt[i]++;
        }

        long ans = 0L;
        for (int i = 1; i <= (k - 1) / 2; i++) {
            if (k - i <= 1000000) ans += (long) cnt[i] * cnt[k - i];
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }
}