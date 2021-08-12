import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class traffic {
	static class Log {
		int dir, a, b;
	}
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("traffic.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("traffic.out")));

		int n = Integer.parseInt(br.readLine());
		Log[] log = new Log[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Log l = new Log();

			String temp = st.nextToken();
			l.dir = temp.equals("none") ? 0 : temp.equals("off") ? 1 : 2;
			l.a = Integer.parseInt(st.nextToken());
			l.b = Integer.parseInt(st.nextToken());

			log[i] = l;
		}
		// backwards
		int a = 0, b = 1000;
		for (int i = n - 1; i >= 0; i--) {
			if (log[i].dir == 0) {
				a = Math.max(a, log[i].a);
				b = Math.min(b, log[i].b);
			} else if (log[i].dir == 1) {
				a += log[i].a;
				b += log[i].b;
			} else {
				a -= log[i].b;
				b -= log[i].a;
			}
		}
		if (a < 0) a = 0;
		pw.println(a + " " + b);
		// calculate forwards
		a = 0; b = 1000;
		for (int i = 0; i < n; i++) {
			if (log[i].dir == 0) {
				a = Math.max(a, log[i].a);
				b = Math.min(b, log[i].b);
			} else if (log[i].dir == 1) {
				a -= log[i].b;
				b -= log[i].a;
			} else {
				a += log[i].a;
				b += log[i].b;
			}
		}
		if (a < 0) a = 0;
		pw.println(a + " " + b);

		br.close();
		pw.close();
	}
}
