import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class blist {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("blist.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));

		int n = Integer.parseInt(br.readLine());
		int[] s = new int[n];
		int[] t = new int[n];
		int[] b = new int[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken()) - 1;
			t[i] = Integer.parseInt(st.nextToken()) - 1;
			b[i] = Integer.parseInt(st.nextToken());
		}
		// simulate each time t
		int max = 0;
		for (int i = 0; i < 1000; i++) {
			int needed = 0;
			for (int j = 0; j < n; j++) {
				if (i >= s[j] && i <= t[j]) {
					needed += b[j];
				}
			}
			max = Math.max(max, needed);
		}

		pw.print(max);
		br.close();
		pw.close();
	}
}
