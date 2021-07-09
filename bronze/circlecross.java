import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class circlecross {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("circlecross.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("circlecross.out"));

		char[] circle = br.readLine().toCharArray();

		int crosses = 0;
		for (int i = 0; i < 26; i++) {
			int[] pos = {-1, 0};
			for (int j = 0; j < 52; j++) {
				if (circle[j] == i + 65) {
					if (pos[0] == -1) pos[0] = j; else pos[1] = j;
				}
			}

			for (int j = pos[0]; j < pos[1]; j++) {
				if (i + 65 < circle[j]) {
					int seen = 0;
					for (int k = pos[0]; k < pos[1]; k++) {
						if (circle[j] == circle[k]) seen++;
					}
					if (seen == 1) crosses++;
				}
			}
		}

		pw.println(crosses);
		br.close();
		pw.close();
	}
}