import java.io.*;

public class Main {
    static final int DIV = 15746;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        if (n == 1) bw.write(1 + "");
        else if (n == 2) bw.write(2 + "");
        else {
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % DIV;
            }
            bw.write(dp[n] + "");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}