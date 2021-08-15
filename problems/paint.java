import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class paint {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("paint.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());

		int ans = -1;
		if (d > b) {
			int temp = a;
			a = c;
			c = temp;
			temp = b;
			b = d;
			d = temp;
		}
		// overlap
		if (d >= a) {
			ans = b - Math.min(a, c);
		// gap
		} else {
			ans = b - a + d - c;
		}

		pw.print(ans);
		br.close();
		pw.close();
	}
}