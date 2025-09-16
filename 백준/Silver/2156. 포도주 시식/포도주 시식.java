import java.io.*;

public class Main {
    static int n;
    static int[] amount , dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        amount = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            amount[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(amount[1]);
            return;
        }

        dp[0] = 0;
        dp[1] = amount[1];
        dp[2] = amount[2] + dp[1];

        find_max();

        bw.write(dp[n] + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void find_max() {
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + amount[i - 1] + amount[i] , Math.max(dp[i - 2] + amount[i] , Math.max(dp[i - 3] + amount[i] , dp[i - 1])));
        }
    }
}