package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_14888 {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	static int[] numArray;
	static int[] calArray = new int[4];
	static LinkedList<Integer> calList = new LinkedList<>();

	static final int PLUS = 0;
	static final int MINUS = 1;
	static final int MUL = 2;
	static final int DIV = 3;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 수 배열 초기화
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numCount = Integer.parseInt(st.nextToken());
		numArray = new int[numCount];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numCount; i++) {
			numArray[i] = Integer.parseInt(st.nextToken());
		}

		// 연산자 배열 초기화
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < calArray.length; i++) {
			calArray[i] = Integer.parseInt(st.nextToken());
		}
		
		calRec();
		
		bw.write(Integer.toString(max));
		bw.write("\n");
		bw.write(Integer.toString(min));
		bw.flush();
		bw.close();

	}

	static void calRec() {
		if (calList.size() == numArray.length - 1) {
			int result = cal();
			if (result > max) max = result;
			if (result < min) min = result;
			return;
		}
		
		for (int i = 0; i < calArray.length; i++) {
			if (calArray[i] > 0) {
				calArray[i]--;
				calList.add(i);
				
				calRec();
				
				calList.removeLast();
				calArray[i]++;
			}
		}
	}

	static int cal() {
		int result = numArray[0];

		for (int i = 0; i < calList.size(); i++) {
			switch (calList.get(i)) {
			case PLUS:
				result += numArray[i+1];
				break;
			case MINUS:
				result -= numArray[i+1];
				break;
			case MUL:
				result *= numArray[i+1];
				break;
			case DIV:
				result /= numArray[i+1];
				break;
			default:
				break;
			}
		}

		return result;
	}
}
