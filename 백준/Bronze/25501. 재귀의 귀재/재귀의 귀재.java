import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int cnt = 1;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			
			sb.append(isPalindrome(word)).append(" ").append(cnt).append("\n");
			cnt = 1;
		}
		
		
		bw.write(String.valueOf(sb));
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int recursion(String s, int l, int r){
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else {
        	cnt++;
        	return recursion(s, l+1, r-1);
        }
    }
	
	public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
}