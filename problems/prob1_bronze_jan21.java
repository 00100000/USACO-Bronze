import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class prob1_bronze_jan21 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String cowphabet = br.readLine();
		String heard = br.readLine();
		// default is 1 because my algorithm doesn't count the first letter
		int timesHummed = 1;

		int[] positions = new int[heard.length()];
		// put all positions of letters into positions[]
		for (int i = 0; i < heard.length(); i++) {
			for (int j = 0; j < cowphabet.length(); j++) {
				if (heard.charAt(i) == cowphabet.charAt(j)) {
					positions[i] = j;
					break;
				}
			}
		}
		// check for all values of position where the next letter is
		// in a lower position than the current letter
		for (int i = 0; i < positions.length - 1; i++) {
			if (positions[i] >= positions[i + 1]) timesHummed++;
		}

		System.out.println(timesHummed);
		br.close();
	}
}