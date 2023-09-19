package problemSolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int size = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				sb.append((isCanEmptySpace(size, i, j) ? " " : "*"));
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		
//		System.out.println(isCanEmptySpace(9, 2, 2));
		bw.flush();
		bw.close();
	}
	
	public static boolean isCanEmptySpace(int maxSize,int row, int col) {
		int now3pow = maxSize;
		int temprow = row;
		int tempcol = col;
		
		while (now3pow >=3) {
			if (now3pow/3 < temprow && temprow <= now3pow/3*2
					&& now3pow/3 < tempcol && tempcol <= now3pow/3*2) {
				return true;
			}
			now3pow = now3pow/3;
			temprow = temprow%now3pow;
			tempcol = tempcol%now3pow;
			
		}
		
		return false;
	}

}
