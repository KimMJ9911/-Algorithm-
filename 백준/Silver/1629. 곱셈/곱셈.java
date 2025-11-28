import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long a , b , c;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //a , b , c 로 두자
        st = new StringTokenizer(br.readLine() , " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        long ans = 1L;

        while (b > 0) {
            if (b % 2 == 1) {
                ans *= a;
                ans %= c;
            }

            a *= a;
            a %= c;
            b /= 2;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }
}