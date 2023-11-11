package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static HashSet<Character> chSet = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String string = br.readLine();
		
		string = string.replaceAll("dz=", "0");
		string = string.replaceAll("z=", "0");
		string = string.replaceAll("c=", "0");
		string = string.replaceAll("c-", "0");
		string = string.replaceAll("d-", "0");
		string = string.replaceAll("lj", "0");
		string = string.replaceAll("nj", "0");
		string = string.replaceAll("s=", "0");
		
		bw.write(Integer.toString(string.length()));
		bw.flush();
		bw.close();
	}
		
}