import java.io.*;
import java.util.*;

public class Main {
    static int[] fibonacci;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        fibonacci = new int[21];
        fibonacci[1] = 1;
        fibonacci[2] = 1;

        if (n >= 3) {
            fibo(n);
        }
        sb.append(fibonacci[n]);

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void fibo(int n) {
        for (int i = 3; i <= n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
    }
}