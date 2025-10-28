import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        BigInteger ans = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            ans = ans.multiply(BigInteger.valueOf(i));
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }
}