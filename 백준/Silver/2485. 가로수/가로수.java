import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> tree = new ArrayList<>();

        //가로수 전체 받기
        for (int i = 0; i < n; i++) {
            tree.add(Integer.parseInt(br.readLine()));
        }

        //가로수 간의 간격 받기
        List<Integer> div = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            div.add(tree.get(i + 1) - tree.get(i));
        }

        int gcd = GCD(div.get(0) , div.get(1));
        for (int i = 1; i < n - 2; i++) {
            gcd = GCD(gcd , GCD(div.get(i + 1) , div.get(i)));
        }

        bw.write(String.valueOf((tree.get(n - 1) - tree.get(0)) / gcd - n + 1));
        bw.flush();
        br.close();
        bw.close();
    }

    private static int GCD(int a, int b) {
        int val = 0;
        do {
            val = a % b;
            a = b;
            b = val;
        } while (val != 0);

        return a;
    }
}