import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class cownomics {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String[] spotty = new String[n], plain = new String[n];

		for (int i = 0; i < n; i++) spotty[i] = br.readLine();
		for (int i = 0; i < n; i++) plain[i] = br.readLine();
		// compare each gene in spotty cows to all the genes in the plain cows
		int possible = 0;
		for (int i = 0; i < m; i++) {
			boolean isPossibleGene = true;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (spotty[j].charAt(j) == plain[k].charAt(i)) {
						isPossibleGene = false;
						break;
					}
				}
			}
			if (isPossibleGene) possible++;
		}

		pw.print(possible);
		br.close();
		pw.close();
	}
}