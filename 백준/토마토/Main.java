package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
	public static int[][] tomatoBox;
	public static boolean[][] searched;
	public static int[] nArray = {1,0,-1,0};
	public static int[] mArray = {0,1,0,-1};
	public static LinkedList<Tomato> tomatoQueue = new LinkedList<>(); 
	public static int day = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		tomatoBox = new int[n][m];
		searched = new boolean[n][m];
		
		// 초기화
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				tomatoBox[i][j] = Integer.parseInt(st.nextToken()); //토마토 박스 초기화
				if (tomatoBox[i][j] == 1 || tomatoBox[i][j] == -1) {
					searched[i][j] = true; // 익었거나 없으면 방문처리
					if (tomatoBox[i][j] == 1) {
						tomatoQueue.add(new Tomato(i, j));
					}
				}
			}
		}
		br.close();
		
		//풀이
		Tomato tomato;
		while (!tomatoQueue.isEmpty()) {
			int tempSize = tomatoQueue.size();
			for (int i = 0; i < tempSize; i++) {
				tomato = tomatoQueue.remove(0);
				for (int j = 0; j < 4; j++) {
					if (0<=tomato.n+nArray[j] && tomato.n+nArray[j] < n && 0<=tomato.m+mArray[j] && tomato.m+mArray[j]< m) {
						if (!searched[tomato.n + nArray[j]][tomato.m + mArray[j]]) {
							tomatoBox[tomato.n + nArray[j]][tomato.m + mArray[j]] = 1;
							searched[tomato.n + nArray[j]][tomato.m + mArray[j]] = true;
							tomatoQueue.add(new Tomato(tomato.n + nArray[j], tomato.m + mArray[j]));
						}
					}
				}
			}
			day++;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (searched[i][j] == false) {
					day = -1;
					break;
				}
			}
			if (day == -1) {
				break;
			}
		}
		
		bw.write(Integer.toString(day));
		bw.flush();
		bw.close();
		
	}
}

class Tomato{
	int n;
	int m;
	
	public Tomato(int n, int m){
		this.n = n;
		this.m = m;
	}
}