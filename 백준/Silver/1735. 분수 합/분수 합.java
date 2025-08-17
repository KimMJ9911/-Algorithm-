import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine() , " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine() , " ");
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        long denominator = LCD(b , d);
        long numerator = a * (denominator / b) + c * (denominator / d);
        long gcd = GCD(denominator , numerator);

        long val1 = numerator / gcd;
        long val2 = denominator / gcd;

        bw.write(val1 + " " + val2);
        bw.flush();
        br.close();
        bw.close();
    }

    private static long LCD(int b, int d) {
        int org_b = b;
        int org_d = d;
        while (d != 0) {
            int temp = d;
            d = b % d;
            b = temp;
        }
        return ((long) org_b * org_d) / b;
    }

    private static long GCD(long denominator , long numerator) {
        while (numerator != 0) {
            long temp = numerator;
            numerator = denominator % numerator;
            denominator = temp;
        }
        return denominator;
    }
}