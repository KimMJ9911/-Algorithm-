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
        int total = Integer.parseInt(st.nextToken()) * 100;
        int cost = Integer.parseInt(st.nextToken());

        if (total < cost) bw.write("No");
        else bw.write("Yes");

        bw.flush();
        br.close();
        bw.close();
    }
}