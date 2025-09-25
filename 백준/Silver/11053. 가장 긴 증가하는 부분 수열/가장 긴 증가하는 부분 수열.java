import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static int n;
    static int[] dp , arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine() , " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + 1 , dp[i]);
                }
            }
        }

        int max = IntStream.of(dp).max().orElse(0);
        bw.write(String.valueOf(max));
        bw.flush();
        br.close();
        bw.close();
    }
}