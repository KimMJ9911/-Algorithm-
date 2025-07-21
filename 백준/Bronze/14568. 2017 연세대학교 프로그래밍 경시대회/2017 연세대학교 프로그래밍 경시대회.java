import java.io.*;

public class Main {
    static int T , Y , N , cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        cnt = 0;
        for (Y = 1; Y <= n - 3; Y++) {
            for (N = Y + 2; N <= n - 1; N++) {
                T = n - Y - N;

                if (T <= 0) break;
                else if (T % 2 == 0) cnt++;
            }
        }

        bw.write(cnt + "");
        bw.flush();
        br.close();
        bw.close();
    }
}