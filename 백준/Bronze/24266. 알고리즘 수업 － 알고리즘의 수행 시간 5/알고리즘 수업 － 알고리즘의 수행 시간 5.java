import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long n = Long.parseLong(br.readLine());
        sb.append(n * n * n).append("\n").append(3);
        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}