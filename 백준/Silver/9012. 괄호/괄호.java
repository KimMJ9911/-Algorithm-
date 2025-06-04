import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            boolean flag = true;
            String[] line = br.readLine().split("");
            for (String s : line) {
                if (s.equals("(")) stack.add("(");
                else {
                    if (stack.isEmpty()){
                        flag = false;
                        break;
                    }
                    else stack.pop();
                }
            }
            if (!flag || !stack.isEmpty()) sb.append("NO");
            else sb.append("YES");

            sb.append("\n");
            stack.clear();
        }
        bw.write(sb + "");
        bw.flush();
        br.close();
        bw.close();
    }
}