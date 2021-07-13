import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class whereami {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("whereami.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("whereami.out"));

		int n = Integer.parseInt(br.readLine());
		String mailboxes = br.readLine();

		for (int i = 1; i < n; i++) {
			boolean isUnique = true;
			// compare each i letter combo starting at j with every possible i letter combo
			// add + 1 to n - i because substring ends indexes are exclusive
			for (int j = 0; j < n - i + 1; j++) {
				int same = 0;
				for (int k = j; k < n - i + 1; k++) {
					if (mailboxes.substring(j, j + i).equals(mailboxes.substring(k, k + i))) {
						same++;
					}
				}
				// saw multiple occurances of a letter combo
				if (same > 1) {
					isUnique = false;
					break;
				}
			}
			// if each i letter is unique
			if (isUnique) {
				pw.println(i);
				break;
			}
		}

		br.close();
		pw.close();
	}
}
