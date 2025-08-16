import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Character> deque = new ArrayDeque<>();

        while (n != 0) {
            int rest = n % m;

            if (rest >= 10) {
                char next = (char) (rest + 'A' - 10);
                deque.offer(next);
            } else {
                char next = (char) (rest + '0');
                deque.offer(next);
            }

            n -= rest;
            n /= m;
        }

        while (!deque.isEmpty()) {
            bw.write(deque.pollLast() + "");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}