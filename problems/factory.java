import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class factory {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("factory.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("factory.out")));

		n = Integer.parseInt(br.readLine());

		// if the station can be reached from all other stations, it must have no outgoing edges
		boolean[] out = new boolean[n];
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			out[Integer.parseInt(st.nextToken()) - 1] = true;
		}
		// find station without outgoing edges
		int sol = -1;
		for (int i = 0; i < n; i++) {
			if (!out[i] && sol == -1) {
				sol = i + 1;
			// if there are two such stations, one station can't reach the other, so there is no
			// solution
			} else if (!out[i]) {
				sol = -1;
				break;
			}
		}

		pw.print(sol);
		br.close();
		pw.close();
	}
}