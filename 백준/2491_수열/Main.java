import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	static int[] array;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int length  = Integer.parseInt(st.nextToken());
		array = new int[length];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < length; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 1;
		int lower = 1;
		int upper = 1;
		for (int index = 0; index < array.length-1; index++) {
			//if next lower
			if (array[index] > array[index+1]) {
				//lower Flag
				lower++;
				//upper Flag
				answer = (upper > answer) ? upper : answer;
				upper = 1;
			}
			//if next upper
			else if (array[index] < array[index+1]) {
				//lower Flag
				answer = (lower> answer) ? lower : answer;
				lower = 1;
				//upper Flag
				upper++;
			} 
			//if same
			else {
				lower++;
				upper++;
			}
		}
		int nowMax = Math.max(upper, lower);
		answer = (nowMax > answer) ? nowMax : answer; 
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
