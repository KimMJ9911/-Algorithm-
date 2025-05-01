import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            int val = k / coin[i];
            k -= val * coin[i];
            sum += val;
            if (k == 0) break;
        }

        bw.write(sum + "");
        bw.flush();
        br.close();
        bw.close();
    }
}