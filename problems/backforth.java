import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class backforth {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("backforth.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));

		int[] aBuckets = new int[12], bBuckets = new int[12];
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < 10; i++) {
			aBuckets[i] = Integer.parseInt(st.nextToken());
			bBuckets[i] = Integer.parseInt(st2.nextToken());
		}
		// simulate
		int totals = 0;
		int vol = 1000;
		// possible values 4 - 1996
		boolean[] seen = new boolean[1992];
		// Tue a - b
		for (int i = 0; i < 10; i++) {
			vol -= aBuckets[i];
			bBuckets[10] = aBuckets[i];
			// Wed b - a
			for (int j = 0; j < 11; j++) {
				vol += bBuckets[j];
				aBuckets[10] = bBuckets[j];
				// Thu a - b
				for (int k = 0; k < 11; k++) {
					if (k == i) continue;
					vol -= aBuckets[k];
					bBuckets[11] = aBuckets[k];
					// Fri a - b
					for (int l = 0; l < 11; l++) {
						if (l == j) continue;
						vol += bBuckets[l];
						bBuckets[11] = bBuckets[k];
						// check if total volume was reached before
						vol += 3;
						if (!seen[vol]) {
							totals++;
							seen[vol] = true;
						}
						vol -= 3;
						// ----------
						vol -= bBuckets[l];
					}
					vol += aBuckets[k];
				}
				vol -= bBuckets[j];
			}
			vol += aBuckets[i];
		}

		pw.print(totals);
		br.close();
		pw.close();
	}
}
