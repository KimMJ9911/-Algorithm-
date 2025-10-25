import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int cnt = 1;
        int n = Integer.parseInt(br.readLine());
        while (n > 1) {
            n -= 6 * cnt;
            cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }
}