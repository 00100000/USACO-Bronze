import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

class blocks {
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
		// print answer
		for (int i = 0; i < 26; i++) {
			pw.println(arr[i]);
		}
		pw.close();
		br.close();
	}

	static void uniqueCharactersInBlock(String firstWord, String secondWord) {
		int[] firstWordCharacters = new int[26];
		int[] secondWordCharacters = new int[26];
		// check every character in firstWord, and increment each position in
		// firstWordCharacters that represents that letter, and do the same for
		// secondWord
		for (int i = 0; i < firstWord.length(); i++) {
			firstWordCharacters[(int) firstWord.charAt(i) - 97]++;
		}
		for (int i = 0; i < secondWord.length(); i++) {
			secondWordCharacters[(int) secondWord.charAt(i) - 97]++;
		}
		// add each greater character position to arr. This works because
		// it gets rid of duplicate characters of words in a block
		for (int i = 0; i < 26; i++) {
			arr[i] += firstWordCharacters[i] > secondWordCharacters[i] ? firstWordCharacters[i]
					: secondWordCharacters[i];
		}
	}
}