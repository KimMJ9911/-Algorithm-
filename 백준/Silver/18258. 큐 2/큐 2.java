import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		Deque<Integer> deque = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			String commend = st.nextToken();
			
			switch (commend) {
			case "push":
				deque.add(Integer.parseInt(st.nextToken())); 
				break;
				
			case "pop":
				if (deque.isEmpty()) sb.append(-1);
				else sb.append(deque.poll());
				sb.append("\n");
				break;
				
			case "size":
				sb.append(deque.size()).append("\n");
				break;
				
			case "empty":
				if (deque.isEmpty()) sb.append(1);
				else sb.append(0);
				sb.append("\n");
				break;
				
			case "front":
				if (!deque.isEmpty()) {
					sb.append(deque.peek());
				}
				else sb.append(-1);
				sb.append("\n");
				break;
				
			case "back":
				if (deque.isEmpty()) sb.append(-1);
				else {
					sb.append(deque.peekLast());
				}
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