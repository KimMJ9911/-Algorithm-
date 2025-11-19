import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] sudoku;
	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		sudoku = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = line.charAt(j) - '0';
			}
		}
		
		DFS();
	}
	static void DFS() {
		int[] next = findZero(); 
		//null 이 출력되면 스도쿠를 모두 완료한 것이므로
		if (next == null) {
			print_table();
			System.exit(0);
		}
		
		int nx = next[0];
		int ny = next[1];
		
		for (int i = 1; i <= 9; i++) {
			if (isValid(nx , ny , i)) {
				sudoku[nx][ny] = i;
				DFS();
				sudoku[nx][ny] = 0;
			}
		}
	}
	//스도쿠 로직 
	static boolean isValid(int x , int y , int p) {
		//가로 축 연산 
		for (int i = 0; i < 9; i++) {
			if (sudoku[i][y] == p) return false;
		}
		
		//세로 축 연산 
		for (int i = 0; i < 9; i++) {
			if (sudoku[x][i] == p) return false;
		}
		//3x3 연산
		//3x3 칸의 시작값을 구하는 연산 
		int dx = (x / 3) * 3;
		int dy = (y / 3) * 3;
		for (int i = dx; i < dx + 3; i++) {
			for (int j = dy; j < dy + 3; j++) {
				if (sudoku[i][j] == p) return false;
			}
		}
		
		return true;
	}
	//0의 위치를 특정하는 메서드 
	static int[] findZero() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sudoku[i][j] == 0) return new int[] {i , j};
			}
		}
		return null;
	}
	
	static void print_table() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(sudoku[i][j]);
			}
			System.out.println();
		}
	}
}