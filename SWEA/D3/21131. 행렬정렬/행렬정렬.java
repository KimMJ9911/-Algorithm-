import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            boolean[] check = new boolean[n];
            for (int k = 0; k < n; k++) {
                st = new StringTokenizer(br.readLine() , " ");
                if (k == 0) {
                    for (int j = 1; j <= n; j++) {
                        int val = Integer.parseInt(st.nextToken());
                        if (val != j) check[j - 1] = false;
                        else check[j - 1] = true;
                    }
                }
            }
            int ans = pulse(check);
            bw.write(ans + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static int pulse(boolean[] check) {
        int cnt = 0;
        for (int i = check.length - 1; i >= 1; i--) {
            if (!check[i]) {
                for (int j = i; j >= 1; j--) {
                    check[j] = !check[j];
                }
                cnt++;
            }
        }

        return cnt;
    }
}