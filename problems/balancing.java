import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class balancing {
	static class Cow {
		int x, y;
	}
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		Cow[] cow = new Cow[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			Cow c = new Cow();
			c.x = Integer.parseInt(st.nextToken());
			c.y = Integer.parseInt(st.nextToken());
			cow[i] = c;
		}
		// check values of x and y next to positions of cows
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int x = cow[i].x + 1;
			for (int j = 0; j < n; j++) {
				int y = cow[j].y + 1;
				// place cows in their respective corners given fences at x and y
				int topR = 0, topL = 0, botR = 0, botL = 0;
				for (int k = 0; k < n; k++) {
					if (cow[k].x > x) {
						if (cow[k].y > y) {
							topR++;
						} else {
							botR++;
						}
					} else {
						if (cow[k].y > y) {
							topL++;
						} else {
							botL++;
						}
					}
				}
				min = Math.min(min, largest(topR, topL, botR, botL));
			}
		}

		pw.println(min);
		br.close();
		pw.close();
	}
	static int largest(int a, int b, int c, int d) {
		return Math.max(Math.max(Math.max(a, b), c), d);
	}
}