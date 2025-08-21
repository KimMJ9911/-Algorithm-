import java.io.*;

public class Main {
    static final int Q = 25 , D = 10 , N = 5 , P = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            int div_Q = n / Q;
            n -= div_Q * Q;
            sb.append(div_Q).append(" ");

            int div_D = n / D;
            n -= div_D * D;
            sb.append(div_D).append(" ");

            int div_N = n / N;
            n -= div_N * N;
            sb.append(div_N).append(" ");

            int div_P = n / P;
            n -= div_P * P;
            sb.append(div_P).append("\n");
        }
        bw.write(sb + "");
        bw.flush();
        br.close();
        bw.close();
    }
}