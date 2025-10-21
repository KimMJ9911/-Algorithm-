import java.io.*;
import java.text.DecimalFormat;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()) - 543;


        bw.write(String.valueOf(n));
        bw.flush();
        br.close();
        bw.close();
    }
}