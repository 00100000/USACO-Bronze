import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

class cowsignal {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cowsignal.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		String expandedLine = "";
		// loop through all lines
		for (int i = 0; i < m; i++) {
			String originalLine = br.readLine();
			// loop through all characters of a line
			for (int j = 0; j < n; j++) {
				// construct expanded line
				for (int l = 0; l < k; l++) {
					expandedLine += originalLine.charAt(j);
				}
			}
			// print expanded line as many times as the signal is dialated
			for (int j = 0; j < k; j++) {
				pw.println(expandedLine);
			}
			// reset expanded line
			expandedLine = "";
		}
		br.close();
		pw.close();
	}
}