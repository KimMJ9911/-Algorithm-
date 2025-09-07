import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Stack<Character> symmetry = new Stack<>();
        while (true) {
            String line = br.readLine();
            symmetry.clear();
            if (line.equals(".")) break;

            boolean flag = true;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                if (c == '(' || c == '[') symmetry.add(c);
                else if (c == ')') {
                    if (!symmetry.isEmpty()){
                        if (symmetry.peek() == '(') symmetry.pop();
                        else {
                            flag = false;
                            break;
                        }
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
                else if (c == ']') {
                    if (!symmetry.isEmpty()) {
                        if (symmetry.peek() == '[') symmetry.pop();
                        else {
                            flag = false;
                            break;
                        }
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
            }

            if (!flag || !symmetry.isEmpty())
                sb.append("no").append("\n");
            else sb.append("yes").append("\n");
        }
        bw.write(sb + "");
        bw.flush();
        br.close();
        bw.close();
    }
}