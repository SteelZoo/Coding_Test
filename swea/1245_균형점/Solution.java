package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//1245 균형점
public class Solution {
	public static int[][] balls;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/swea/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int countBall = Integer.parseInt(st.nextToken());
			// init array
			balls = new int[countBall][2];
			double[] answer = new double[countBall - 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < countBall; i++) {
				balls[i][0] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < countBall; i++) {
				balls[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(balls, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			
			answer = getAnswerArray();

			bw.write("#" + test_case);
			for (double d : answer) {
				bw.write(" " + String.format("%.10f", d));
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	public static double[] getAnswerArray() {
		int count = balls.length;
		double[] result = new double[count - 1];

		for (int i = 0; i < result.length; i++) {
			int leftIndex = i;
			int rightIndex = i + 1;
			double leftPoint = balls[leftIndex][0];
			double rigthPoint= balls[rightIndex][0];
			double nowPoint = (rigthPoint+leftPoint)/2;
;			double beforePoint = nowPoint;
			
			int balanceFlag = isBalancePoint(leftIndex, rightIndex, nowPoint);
			while (balanceFlag != 0) {
				if (balanceFlag == -1) {
					leftPoint = nowPoint;
				} else if (balanceFlag == 1) {
					rigthPoint = nowPoint;
				}
				beforePoint = nowPoint;
				nowPoint = (rigthPoint+leftPoint)/2;
//				nowPoint = Math.round(nowPoint*Math.pow(10, 12))/Math.pow(10, 12);
				
				balanceFlag = isBalancePoint(leftIndex, rightIndex, nowPoint );
				if (beforePoint == nowPoint) {
					break;
				}
			}
			result[i] = nowPoint;
		}

		return result;
	}

	/**
	 * @param leftIndex  nearest left from now point
	 * @param rightIndex nearest right from now point
	 * @param nowPoint
	 * @return
	 */
	public static int isBalancePoint(int leftIndex, int rightIndex, double nowPoint) {
		int result = 0;
		double leftG = 0;
		double rightG = 0;
		
		double f = 0;

		// get left side total Gravity
		for (int i = leftIndex; i >= 0; i--) {
			leftG += calForce(nowPoint, balls[i][0], balls[i][1]);
		}
		// get right side total Gravity
		for (int i = rightIndex; i < balls.length; i++) {
			rightG += calForce(nowPoint, balls[i][0], balls[i][1]);
		}
		
		if (leftG > rightG) {
			return -1;
		} else if (leftG < rightG) {
			return 1;
		} else {
			return 0;
		}
	
	}

	public static double calForce(double nowPosition, int ballPosition, int ballM) {
		return ballM / Math.pow(ballPosition - nowPosition, 2);
	}
}
