import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class pails {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("pails.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// check all possible adding combinations
		int maxTotal = 0;
		for (int i = 0; i*y <= m; i++) {
			int total = 0;
			total += i*y;
			// fill rest of total with x
			while (total + x <= m) total += x;
			maxTotal = Math.max(maxTotal, total);
		}

		pw.print(maxTotal);
		br.close();
		pw.close();
	}
}