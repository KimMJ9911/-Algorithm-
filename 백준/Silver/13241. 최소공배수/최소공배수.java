import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine() , " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int gcd = GCD(A , B);
        long lcd = ((long) A * B) / gcd;

        bw.write(lcd + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b  = a % b;
            a = temp;
        }

        return a;
    }
}