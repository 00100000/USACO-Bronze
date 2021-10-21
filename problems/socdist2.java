import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class socdist2 {
	static class Cow {
		boolean s;
		int x;
	}
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("socdist2.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("socdist2.out")));

		int n = Integer.parseInt(br.readLine());
		Cow[] cows = new Cow[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Cow c = new Cow();
			c.x = Integer.parseInt(st.nextToken());
			c.s = Integer.parseInt(st.nextToken()) == 1;
			cows[i] = c;
		}
		Arrays.sort(cows, new Comparator<Cow>() {
			@Override
			public int compare(Cow c1, Cow c2) {
				return c1.x - c2.x;
			}
		});
		// find r by finding the smallest distance between a healthy and sick cow - 1
		int r = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i++) {
			if (cows[i].s != cows[i + 1].s) {
				r = Math.min(r, cows[i + 1].x - cows[i].x - 1);
			}
		}

		int ans = 0;
		if (cows[0].s) ans++;
		for (int i = 1; i < n; i++) {
			// if a new "block" of sick cows is found
			if (cows[i].s && !cows[i - 1].s) {
				ans++;
			}
			// if two sick cows are r apart
			else if (cows[i].s && cows[i - 1].s && cows[i].x - cows[i - 1].x > r) {
				ans++;
			}
		}

		pw.print(ans);
		br.close();
		pw.close();
	}
}
