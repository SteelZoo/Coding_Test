package problemSolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	static int white = 0;
	static int blue = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int size = Integer.parseInt(st.nextToken());
		int[][] fullPaper = new int[size][size];
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				fullPaper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		getColorsCount(fullPaper);

		bw.write(white + "\n");
		bw.write(blue + "");
		bw.flush();
		bw.close();

	}

	public static void getColorsCount(int[][] paper) {
		// if size 1
		if (paper.length == 1) {
			addColor(paper[0][0]);
			return;
		}
		// if all same color count colorNumber
		int sameFlag = isAllSame(paper);
		if (sameFlag != -1) {
			addColor(sameFlag);
			return;
		}
		int[][][] devided = devideFour(paper);
		for (int i = 0; i < devided.length; i++) {
			getColorsCount(devided[i]);
		}
	}

	/**
	 * @param paper int[][]
	 * @return isAllNotSame : -1, All blue : 1, All white : 0
	 */
	public static int isAllSame(int[][] paper) {
		int target = paper[0][0];

		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper[i].length; j++) {
				if (paper[i][j] != target) {
					return -1;
				}
			}
		}

		return target;
	}

	public static void addColor(int color) {
		if (color == 1) {
			blue++;
		} else if (color == 0) {
			white++;
		}
	}

	public static int[][][] devideFour(int[][] paper) {
		int[][][] result = new int[4][paper.length / 2][paper.length / 2];
		int len = paper.length;
		int rowS = -1;
		int rowE = -1;
		int colS = -1;
		int colE = -1;

		/*
		 * 0 len/2 
		 * 0 len/2
		 * 
		 * len/2 len 
		 * 0 len/2
		 * 
		 * 0 len/2 
		 * len/2 len
		 * 
		 * len/2 len 
		 * len/2 len
		 * 
		 */

		for (int count = 0; count < 4; count++) {
			int row = 0;
			int col = 0;
			switch (count) {
			case 0: 
				rowS = 0;rowE=len/2;colS=0;colE=len/2;
				break;
			case 1:
				rowS = 0;rowE=len/2;colS=len/2;colE=len;
				break;
			case 2:
				rowS = len/2;rowE=len;colS=0;colE=len/2;
				break;
			default:
				rowS = len/2;rowE=len;colS=len/2;colE=len;
				break;
			}
			
			for (int i = rowS; i < rowE; i++) {
				col = 0;
				for (int j = colS; j < colE; j++) {
					result[count][row][col] = paper[i][j];
					col++;
				}
				row++;
			}
		}

		return result;
	}

}
