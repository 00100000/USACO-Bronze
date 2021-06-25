import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class cownomics {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("cownomics.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int possible = 0;

		char[][] spotty = new char[n][m];
		char[][] plain = new char[n][m];
		
		for (int i = 0; i < n; i++) spotty[i] = br.readLine().toCharArray();
		for (int i = 0; i < n; i++) plain[i] = br.readLine().toCharArray();
		// compare each gene in spotty cows to all the genes in the plain cows
		for (int i = 0; i < m; i++) {
			boolean isPossibleGene = true;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (spotty[j][i] == plain[k][i]) isPossibleGene = false;
				}
			}
			if (isPossibleGene) possible++;
		}
		
		pw.println(possible);
		br.close();
		pw.close();
	}
}