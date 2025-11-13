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
        //창문이 닫혀 있어야 하려면 약수가 홀수개여야 한다. -> 누군가의 제곱수여야 한다.
        //대부분 1 , 12 / 2 , 6 / 3 , 4 등 열었다 다시 닫히기 때문에 그대로
        //제곱수의 경우 자기 자신이므로 열어도 다시 닫지 않고 닫아도 다시 열지 않음
        int n = Integer.parseInt(br.readLine());
        sb.append((int) Math.sqrt(n)).append("\n");

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}