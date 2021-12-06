import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class guess {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("guess.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));

		int n = Integer.parseInt(br.readLine());
		ArrayList<String>[] animals = new ArrayList[n];
		// construct ArrayList[]
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			animals[i] = new ArrayList<String>(0);
			st.nextToken();
			int cnt = Integer.parseInt(st.nextToken());
			// add traits
			for (int j = 0; j < cnt; j++) {
				animals[i].add(st.nextToken());
			}
		}
		// find the two animals that share the most traits
		int max = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int shared = 0;
				for (int k = 0; k < animals[i].size(); k++) {
					for (int l = 0; l < animals[j].size(); l++) {
						if (animals[i].get(k).equals(animals[j].get(l))) {
							shared++;
							break;
						}
					}
				}
				max = Math.max(max, shared);
			}
		}
		// + 1 for the confirmation guess
		pw.print(max + 1);
		br.close();
		pw.close();
	}
}
