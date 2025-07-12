import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int cnt_1;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        cnt_1 = 1;
        arr = new int[n + 1];

        fibo_1(n);

        bw.write(cnt_1 + " " + (n - 2));
        bw.flush();
        br.close();
        bw.close();
    }
    static int fibo_1(int n) {
        cnt_1++;
        if (n == 1 || n == 2) {
            cnt_1--;
            return 1;
        }
        else return fibo_1(n - 1) + fibo_1(n - 2);
    }
}