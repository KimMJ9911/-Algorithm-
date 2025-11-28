import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int commend = 0 , val = 0;
            String line = br.readLine();
            if (line.length() == 1) commend = Integer.parseInt(line);
            else {
                st = new StringTokenizer(line , " ");
                commend = Integer.parseInt(st.nextToken());
                val = Integer.parseInt(st.nextToken());
            }

            switch (commend) {
                case 1:
                    deque.addFirst(val);
                    break;

                case 2:
                    deque.addLast(val);
                    break;

                case 3:
                    if (deque.isEmpty()) sb.append(-1);
                    else sb.append(deque.pollFirst());
                    sb.append("\n");
                    break;

                case 4:
                    if (deque.isEmpty()) sb.append(-1);
                    else sb.append(deque.pollLast());
                    sb.append("\n");
                    break;

                case 5:
                    sb.append(deque.size()).append("\n");
                    break;

                case 6:
                    if (deque.isEmpty()) sb.append(1);
                    else sb.append(0);
                    sb.append("\n");
                    break;

                case 7:
                    if (deque.isEmpty()) sb.append(-1);
                    else sb.append(deque.peekFirst());
                    sb.append("\n");
                    break;

                case 8:
                    if (deque.isEmpty()) sb.append(-1);
                    else sb.append(deque.peekLast());
                    sb.append("\n");
                    break;

                default:
                    break;

            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}