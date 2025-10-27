import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int A = Integer.parseInt(br.readLine());
        String[] B = br.readLine().split("");
        int sum = 0;
        int[] C = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            C[i] = Integer.parseInt(B[i]);
        }

        int ten = 1;
        for (int i = C.length - 1; i >= 0; i--) {
            int val = A * C[i];
            sb.append(val).append("\n");
            sum += val * ten;
            ten *= 10;
        }
        sb.append(sum);

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}