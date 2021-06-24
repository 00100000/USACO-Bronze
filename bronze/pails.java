import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class pails {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("pails.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("pails.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// check all possible adding combinations
		int total = 0;
		int maxTotal = 0;
		for (int i = 0; i*y <= m; i++) {
			total += i*y;
			// fill rest of total with x
			while (total + x <= m) {
				total += x;
			}
			if (total > maxTotal) maxTotal = total;
			total = 0;
		}

		pw.println(maxTotal);
		br.close();
		pw.close();
	}
}