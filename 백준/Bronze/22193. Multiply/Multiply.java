import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //BigInteger 은 메모리가 허락하는 이상 길이가 거의 무한대
        String a = br.readLine();
        String b = br.readLine();
        //String -> BigInteger 로 전환하는 방법 배우기
        BigInteger B_a = new BigInteger(a);
        BigInteger B_b = new BigInteger(b);

        bw.write(String.valueOf(B_a.multiply(B_b)));
        bw.flush();
        br.close();
        bw.close();
    }
}