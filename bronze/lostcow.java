import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class lostcow {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("lostcow.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int find = -(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));

		int check = -2;
		int steps = 1;
		boolean found = false;
		// special cases
		if (find == 0 || find == 1) found = true;
		if (find == 0) steps = 0;
		// simulate
		// I feel like there is a bigbrain math way to do this, with only a tiny bit of iteration,
		// but x and y are both <= 1000 and I can't figure it out
		while (!found) {
			for (int i = check / -2 + 1; i <= check; i++) {
				steps++;
				if (find == i) {
					found = true;
					break;
				}
			}
			for (int i = check / -2 - 1; i >= check; i--) {
				steps++;
				if (find == i) {
					found = true;
					break;
				}
			}
			if (found) break;
			check *= -2;
		}

		pw.println(steps);
		br.close();
		pw.close();
	}
}
