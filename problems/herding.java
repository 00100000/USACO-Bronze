import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class herding {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("herding.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] c = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		Arrays.sort(c);

		int highDiff = c[2] - c[1];
		int lowDiff = c[1] - c[0];
		if (c[0] + 1 == c[1] && c[1] + 1 == c[2]) {
			pw.println(0);
		} else if (highDiff > 2 && lowDiff > 2) {
			pw.println(2);
		} else if (highDiff > 2 && lowDiff == 1) {
			pw.println(2);
		} else if (lowDiff > 2 && highDiff == 1) {
			pw.println(2);
		} else {
			pw.println(1);
		}
		pw.println(Math.max(highDiff, lowDiff) - 1);
		br.close();
		pw.close();
	}
}