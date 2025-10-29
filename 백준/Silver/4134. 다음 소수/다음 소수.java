import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String a = br.readLine();
            BigInteger val = new BigInteger(a);

            boolean flag = false;
            while (true) {
                flag = val.isProbablePrime(100);

                if (flag) {
                    sb.append(val).append("\n");
                    break;
                } else val = val.add(BigInteger.ONE);
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}