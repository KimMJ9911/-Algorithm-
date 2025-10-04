import java.io.*;
import java.math.BigInteger;
import java.util.stream.IntStream;

public class Main {
    static BigInteger ans = BigInteger.ONE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        IntStream.rangeClosed(2 , n).forEach(i -> {
            ans = ans.multiply(BigInteger.valueOf(i));
        });

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }
}