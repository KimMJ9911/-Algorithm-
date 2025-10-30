import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static List<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String nick = br.readLine();

            if (nick.equals("ENTER")) {
                cnt += set.size();
                set.clear();
            }
            else {
                set.add(nick);
            }
        }

        cnt += set.size();
        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }
}