import java.io.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static String n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = br.readLine();
        StringBuilder num;
        for (int i = 1; i < 1_000_000; i++) {
            find_gen(String.valueOf(i));
        }


        if (min == Integer.MAX_VALUE) bw.write(0 + "");
        else bw.write(min + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void find_gen(String num) {
        int org = Integer.parseInt(num);

        int m = org;
        for (int i = 0; i < num.length(); i++) {
            m += num.charAt(i) - '0';
        }

        if (Integer.parseInt(n) == m) min = Math.min(min , org);
        if (Integer.parseInt(n) == m) min = Math.min(min , org);
    }
}