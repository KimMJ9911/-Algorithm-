import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            Stack<Integer> ans = new Stack<>();

            stack.addAll(Arrays.asList(line));

            int sum = 0;
            while (true) {
                if (stack.isEmpty()) break;
                String next = stack.pop();
                if (next.equals("+")) {
                } else if (next.equals("*")) {
                    int a = ans.pop();
                    int b = Integer.parseInt(stack.pop());
                    ans.add(a * b);
                } else ans.add(Integer.parseInt(next));
            }

            for (Integer an : ans) {
                sum += an;
            }

            sb.append("#").append(i).append(" ").append(sum).append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}