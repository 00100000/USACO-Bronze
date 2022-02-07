import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class tracing {
	static public class Handshake {
		int t, x, y;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("tracing.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tracing.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		boolean[] infected = new boolean[n];
		String s = br.readLine();
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '1') infected[i] = true;
		}
		Handshake[] handshakes = new Handshake[t];
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			handshakes[i] = new Handshake();
			handshakes[i].t = Integer.parseInt(st.nextToken());
			handshakes[i].x = Integer.parseInt(st.nextToken()) - 1;
			handshakes[i].y = Integer.parseInt(st.nextToken()) - 1;
		}
		// sort handshakes by time
		Arrays.sort(handshakes, new Comparator<Handshake>() {
			@Override
			public int compare(Handshake h1, Handshake h2) {
				return h1.t - h2.t;
			}
		});
		// check if each infected cow was patient 0
		int p0s = 0;
		int minK = 251, maxK = 0;
		for (int i = 0; i < n; i++) {
			boolean isp0 = false;
			if (infected[i]) {
				// check if each value of k can result in a valid ordering
				for (int j = 0; j <= 251; j++) {
					boolean isValidK = true;
					// -1 = healthy cow
					// 0 = infected cow with clean hooves
					int[] handshakesLeft = new int[n];
					Arrays.fill(handshakesLeft, -1);
					// set patient zero
					handshakesLeft[i] = j;
					// simulate all handshakes
					for (int k = 0; k < t; k++) {
						int x = handshakesLeft[handshakes[k].x], y = handshakesLeft[handshakes[k].y];
						if (x > 0) {
							x--;
							// j + 1 to offset j-- because j will be >= 0
							// I wrote all this working code in 30 minutes and spend over 90
							// minutes on this bug. Life is pain.
							if (y == -1) y = j + 1;
						}
						if (y > 0) {
							y--;
							if (x == -1) x = j;
						}
						handshakesLeft[handshakes[k].x] = x; handshakesLeft[handshakes[k].y] = y;
					}
					// check if array matches farmer john's findings
					for (int k = 0; k < n; k++) {
						if (handshakesLeft[k] >= 0 != infected[k]) {
							isValidK = false;
							break;
						}
					}
					// edit k values
					if (isValidK) {
						isp0 = true;
						minK = Math.min(minK, j);
						maxK = Math.max(maxK, j);
					}
				}
			}
			if (isp0) p0s++;
		}

		pw.print(p0s + " " + minK + " " + (maxK == 251 ? "Infinity" : maxK));
		br.close();
		pw.close();
	}
}
