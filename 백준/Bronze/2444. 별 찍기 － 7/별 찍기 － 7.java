import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            sb.append(" ".repeat(Math.max(0 , n - i)));
            sb.append("*".repeat(Math.max(0 , 2 * i - 1))).append("\n");
        }

        for (int i = n - 1; i > 0; i--) {
            sb.append(" ".repeat(Math.max(0 , n - i)));
            sb.append("*".repeat(Math.max(0 , 2 * i - 1))).append("\n");
        }

        bw.write(sb + "");
        bw.flush();
        br.close();
        bw.close();
    }
}