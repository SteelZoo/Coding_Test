import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	public static LinkedList<Integer> round;
	public static Set<Integer> set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			round = new LinkedList<Integer>();
			set = new HashSet<Integer>();
			
			st = new StringTokenizer(br.readLine());
			
			int numberCount = Integer.parseInt(st.nextToken());
			int Nth = Integer.parseInt(st.nextToken());
			
			String[] oneLine = br.readLine().split("");
			for (int i = 0; i < oneLine.length; i++) {
				round.add(Integer.parseInt(oneLine[i],16));
			}
			
			for (int rep = 0; rep < numberCount; rep++) {
				round.add(round.poll());
				getNumbers(numberCount);
			}
			
			Integer[] temp = set.toArray(new Integer[set.size()]);
			Arrays.sort(temp,(o1,o2)->{
				return o2-o1;
			});
			
			bw.write("#" + test_case +" " +temp[Nth-1]+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void getNumbers(int numberCount) {
		int eachSize = numberCount/4;
		
		for (int i = 0; i < round.size(); i+=eachSize) {
			int sum = 0;
			for (int j = i; j < eachSize; j++) {
				sum += (int) (round.get(j) * Math.pow(16,eachSize-(j-i)-1));
			}
			set.add(sum);
		}
	}
}