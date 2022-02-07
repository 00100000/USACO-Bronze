import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class blocks {
	private static int[] arr = new int[26];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		// find unique characters in each block
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			uniqueCharactersInBlock(st.nextToken(), st.nextToken());
		}
		for (int i = 0; i < 26; i++) {
			pw.println(arr[i]);
		}

		pw.close();
		br.close();
	}

	static void uniqueCharactersInBlock(String first, String second) {
		int[] firstChars = new int[26];
		int[] secondChars = new int[26];
		for (int i = 0; i < first.length(); i++) {
			firstChars[(int) first.charAt(i) - 97]++;
		}
		for (int i = 0; i < second.length(); i++) {
			secondChars[(int) second.charAt(i) - 97]++;
		}
		for (int i = 0; i < 26; i++) {
			arr[i] += firstChars[i] > secondChars[i] ? firstChars[i] : secondChars[i];
		}
	}
}