import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class circlecross {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("circlecross.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));

		char[] circle = st.nextToken().toCharArray();
		int crossingPaths = 0;
		// loop through letters A-Z
		for (int i = 0; i < 26; i++) {
			// find the positions of the letter
			int[] pos = { -1, 0 };
			for (int j = 0; j < 52; j++) {
				if (65 + i == circle[j]) {
					if (pos[0] == -1) {
						pos[0] = j;
					} else {
						pos[1] = j;
					}
				}
			}
			// store letters in between the letter
			char[] between = new char[pos[1] - pos[0]];
			for (int j = pos[0], bj = 0; j < pos[1]; j++, bj++) {
				between[bj] = circle[j];
			}
			// check if each letter is alone
			for (int j = 0; j < between.length; j++) {
				// don't check for letters below i alphabetically
				// or there will be 2 crossing paths for 1
				if (65 + i < (int) between[j]) {
					int seen = 0;
					for (int k = 0; k < between.length; k++) {
						if (between[j] == between[k])
							seen++;
					}
					if (seen == 1)
						crossingPaths++;
				}
			}

		}

		pw.println(crossingPaths);
		br.close();
		pw.close();
	}
}