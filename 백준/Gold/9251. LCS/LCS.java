import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] stat = br.readLine().split("");
        String[] comp = br.readLine().split("");
        int[][] dp = new int[comp.length + 1][stat.length + 1];

        for (int i = 1; i <= comp.length; i++) {
            for (int j = 1; j <= stat.length; j++) {
                if (comp[i - 1].equals(stat[j - 1]))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i][j - 1] , dp[i - 1][j]);
            }
        }

        bw.write(String.valueOf(dp[comp.length][stat.length]));
        bw.flush();
        br.close();
        bw.close();
    }
}