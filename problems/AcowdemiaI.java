import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AcowdemiaI1131 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] c = new int[n];
		for (int i = 0; i < n; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(c);
		// find h index
		int h = 0;
		for (int i = n - 1, j = 1; i >= 0; i--, j++) {
			if (c[i] >= j) h++;
		}
		// count number of papers that must be increased to increase the h index
		// (i.e. papers with value h after the h index point)
		int cnt = 0;
		for (int i = n - h - 1; i < n; i++) {
			if (c[i] == h) cnt++;
		}
		if (cnt > l || c[n - h - 1] != h) {
			pw.print(h);
		} else {
			pw.print(h + 1);
		}

		br.close();
		pw.close();
	}
}