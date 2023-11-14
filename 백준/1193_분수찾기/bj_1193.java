package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj_1193 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int target = Integer.parseInt(br.readLine());
		
		int line = 1;
		int numInLine = target;
		
		while ((numInLine - line)>0) {
			numInLine -= line;
			line++;
		}
		
		
		int child = 0;
		int parent = line+1;
		for (int i = 0; i < numInLine; i++) {
			child++;
			parent--;
		}
		
		if (line%2 == 1) {
			int temp = child;
			child = parent;
			parent = temp;
		}
		
		bw.write(child +"/"+ parent);
		bw.flush();
		bw.close();
	}

}
