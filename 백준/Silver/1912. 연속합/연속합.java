import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        int MAX = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine() , " ");
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int val = Integer.parseInt(st.nextToken());
            dp[i] = dp[i - 1] + val;
            MAX = Math.max(dp[i] , MAX);
            if (dp[i] < 0) dp[i] = 0;
        }

        bw.write(MAX + "");
        bw.flush();
        bw.close();
        br.close();
    }
}