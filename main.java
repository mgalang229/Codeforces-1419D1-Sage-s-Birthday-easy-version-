import java.io.*;
import java.util.*;

public class Main {
	
	private static FastReader in;
	
	public static void main(String[] args) {
		in = new FastReader();
		int tc = 1;
//		tc = in.nextInt();
		for(int t = 0; t < tc; t++) {
			new Solver();
		}
	}
	
	static class Solver {
		Solver() {
			int n = in.nextInt();
			int[] a = new int[n];
			for(int i = 0; i < n; i++) {
				a[i] = in.nextInt();
			}
			// simply place the smaller numbers in even positions and bigger numbers in odd positions
			Arrays.sort(a);
			int[] newSeq = new int[n];
			int id = 0;
			for(int i = 0; i < n; i++) {
				if((i + 1) % 2 == 0 && id < n) {
					newSeq[i] = a[id++]; 
				}
			}
			id = n - 1;
			for(int i = 0; i < n; i++) {
				if((i + 1) % 2 == 1 && id >= 0) {
					newSeq[i] = a[id--];
				}
			}
			int cnt = 0;
			for(int i = 1; i + 1 < n; i++) {
				if(newSeq[i] < newSeq[i-1] && newSeq[i] < newSeq[i+1]) {
					cnt++;
				}
			}
			System.out.println(cnt);
			for(int i = 0; i < n; i++) {
				System.out.print(newSeq[i] + " ");
			}
			System.out.println();
		}
	}
	
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
