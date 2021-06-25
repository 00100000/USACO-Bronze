import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class cowsignal {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cowsignal.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		String expandedLine = "";
		for (int i = 0; i < m; i++) {
			String originalLine = br.readLine();
			for (int j = 0; j < n; j++) {
				for (int l = 0; l < k; l++) {
					expandedLine += originalLine.charAt(j);
				}
			}
			for (int j = 0; j < k; j++) {
				pw.println(expandedLine);
			}
			// reset
			expandedLine = "";
		}
		br.close();
		pw.close();
	}
}