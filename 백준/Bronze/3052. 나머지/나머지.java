import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            int val = Integer.parseInt(br.readLine()) % 42;
            set.add(val);
        }


        bw.write(String.valueOf(set.size()));
        bw.flush();
        br.close();
        bw.close();
    }
}