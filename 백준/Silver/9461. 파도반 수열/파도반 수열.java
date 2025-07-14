import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        for (int j = 0; j < T; j++) {
            int n = Integer.parseInt(br.readLine());


            if (n <= 3) bw.write(1 + "\n");
            else {
                dp[1] = 1;
                dp[2] = 1;
                dp[3] = 1;

                for (int i = 4; i <= n; i++) {
                    dp[i] = dp[i - 2] + dp[i - 3];
                }
                bw.write(dp[n] + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}