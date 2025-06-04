import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            switch (cnt) {
                case 1:
                    int val = Integer.parseInt(st.nextToken());
                    stack.add(val);
                    break;
                case 2:
                    if (stack.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(stack.pop()).append("\n");
                    break;
                case 3:
                    sb.append(stack.size()).append("\n");
                    break;
                case 4:
                    if (stack.isEmpty()) sb.append("1");
                    else sb.append("0");
                    sb.append("\n");
                    break;
                case 5:
                    if (stack.isEmpty()) sb.append("-1");
                    else sb.append(stack.peek());
                    sb.append("\n");
                    break;
                default:
                    break;
            }
        }
        bw.write(sb + "");
        bw.flush();
        br.close();
        bw.close();
    }
}