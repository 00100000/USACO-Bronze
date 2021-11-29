import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class badmilk {
	static class Event {
		int p, m = -1, t;
	}
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("badmilk.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		Event[] drink = new Event[d];
		for (int i = 0; i < d; i++) {
			Event e = new Event();
			st = new StringTokenizer(br.readLine());

			e.p = Integer.parseInt(st.nextToken());
			e.m = Integer.parseInt(st.nextToken());
			e.t = Integer.parseInt(st.nextToken());
			drink[i] = e;
		}

		Event[] sick = new Event[s];
		for (int i = 0; i < s; i++) {
			Event e = new Event();
			st = new StringTokenizer(br.readLine());

			e.p = Integer.parseInt(st.nextToken());
			e.t = Integer.parseInt(st.nextToken());
			sick[i] = e;
		}

		int max = 0;
		for (int i = 1; i <= m; i++) {
			// check if all the sick people drank milk i before getting sick
			boolean isValid = true;
			for (int j = 0; j < s; j++) {
				boolean madeJSick = false;
				for (int k = 0; k < d; k++) {
					// if sick person j drank milk i before getting sick
					if (drink[k].m == i && sick[j].p == drink[k].p && sick[j].t > drink[k].t) {
						madeJSick = true;
						break;
					}
				}
				if (!madeJSick) {
					isValid = false;
					break;
				}
			}
			// count how many people drank milk m
			if (isValid) {
				int cnt = 0;
				for (int j = 1; j <= n; j++) {
					for (int k = 0; k < d; k++) {
						if (drink[k].p == j && drink[k].m == i) {
							cnt++;
							break;
						}
					}
				}
				max = Math.max(max, cnt);
			}
		}

		pw.print(max);
		br.close();
		pw.close();
	}
}
