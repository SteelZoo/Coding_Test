import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.StringTokenizer;

//1258 행렬찾기
public class Solution {
	public static int[][] map;
	public static boolean[][] visited;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		// each case
		for (int test_case = 1; test_case <= T; test_case++) {

			//read input, init data
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			map = new int[size][size];
			visited = new boolean[size][size];
			
			for (int i = 0; i < size; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < size; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ArrayList<Matrix> tempList = getMatrixes();
			tempList.sort((o1,o2)->{
				if ((o1.rowSize*o1.colSize)-(o2.rowSize*o2.colSize) != 0) {
					return (o1.rowSize*o1.colSize)-(o2.rowSize*o2.colSize);
				}
				return o1.rowSize - o2.rowSize;
			});
			
			bw.write("#" + test_case + " " + tempList.size());
			for (Matrix matrix : tempList) {
				bw.write(" " + matrix.rowSize + " " + matrix.colSize);
			}
			bw.write("\n");
		} // each case
		bw.flush();
		bw.close();
	}
	public static ArrayList<Matrix> getMatrixes() {
		ArrayList<Matrix> resultList = new ArrayList<>();
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 0 && visited[i][j] == false) {
					Matrix temp = getOneMatrix(i,j);
					resultList.add(temp);
				}
			}
		}
		
		return resultList;
	}
	
	public static Matrix getOneMatrix(int row, int col) {
		Matrix result = new Matrix();
		int rowSize = 0;
		int colSize = 0;
		
		//어떻게 동적으로 구하지?
		//get row size
		while (map[row+rowSize][col] != 0) {
			rowSize++;
			if (row+rowSize >= map.length) {
				break;
			}
		}
		//get col size
		while (map[row][col+colSize] != 0) {
			colSize++;
			if (col+colSize >= map[0].length) {
				break;
			}
		}
		
		result.array = new int[rowSize][colSize];
		
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				visited[row+i][col+j] = true;
			}
		}
		
		result.setSize();
		return result;
	}
}

class Matrix{
	int rowSize;
	int colSize;
	int[][] array;
	
	public void setSize() {
		rowSize = array.length;
		colSize = array[0].length;
	}
}
