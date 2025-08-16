import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        String word = st.nextToken();
        int n = Integer.parseInt(st.nextToken());
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            stack.add(word.charAt(i));
        }

        long ans = 0;
        int cnt = 0;

        while (!stack.isEmpty()) {
            char next = stack.pop();
            int mul = (int) Math.pow(n , cnt);

            if (next >= 65) ans += (long) (next - 'A' + 10) * mul;
            else ans += (long) (next - '0') * mul;

            cnt++;
        }

        bw.write(ans + "");
        bw.flush();
        br.close();
        bw.close();
    }
}