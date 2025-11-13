import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] valid;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //5 -> 11111 -> 10101 -> 10001 -> 10011 -> 10010
        //일단 소수들은 무조건 닫혀있음
        //소수들의 배수들 중 짝수 번 -> 창문이 열려 있으려면 누군가의 제곱수여야 한다.
        int n = Integer.parseInt(br.readLine());
        sb.append((int) Math.sqrt(n)).append("\n");

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}