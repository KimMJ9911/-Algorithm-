import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

         long n = Long.parseLong(br.readLine()) * 4;

        bw.write(String.valueOf(n));
        bw.flush();
        br.close();
        bw.close();
    }
}