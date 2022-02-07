import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class YearOfTheCow1107 {
	static String[] cycle = { "Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat" };
	static HashMap<String, String> mentioned = new HashMap<String, String>(0);

	static public class Relation {
		String a, b;
		// int years a is older than b (can be negative)
		int dif;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		mentioned.put("Bessie", "Ox");

		int n = Integer.parseInt(br.readLine());

		Relation[] r = new Relation[n];
		for (int i = 0; i < n; i++) {
			Relation temp = new Relation();
			StringTokenizer st = new StringTokenizer(br.readLine());

			temp.a = st.nextToken();
			st.nextToken(); st.nextToken();
			boolean positive = st.nextToken().equals("previous");
			String year = st.nextToken();
			st.nextToken(); st.nextToken();
			temp.b = st.nextToken();
			temp.dif = parseDif(positive, year, mentioned.get(temp.b));

			mentioned.put(temp.a, year);
			r[i] = temp;
		}
		// find how far apart each cow is from Bessie's birth year
		HashMap <String, Integer> yearsFromBessie = new HashMap<String, Integer>(0);
		yearsFromBessie.put("Bessie", 0);
		for (int i = 0; i < n; i++) {
			if (r[i].a.equals("Elsie")) {
				pw.print(Math.abs(r[i].dif + yearsFromBessie.get(r[i].b)));
				break;
			}
			yearsFromBessie.put(r[i].a, r[i].dif + yearsFromBessie.get(r[i].b));
		}

		br.close();
		pw.close();
	}
	// return the amount of years cow a is older than cow b (can be negative)
	static int parseDif(boolean positive, String a, String b) {
		int dif = 0;
		for (int i = 0; i < 12; i++) {
			if (cycle[i].equals(a)) {
				// look for next year in cycle year b is seen
				if (positive) {
					dif++;
					for (int j = i + 1; j < 12; j++) {
						if (cycle[j].equals(b)) {
							return dif;
						} else {
							dif++;
						}
					}
					// reset to bottom of cycle
					for (int j = 0; j < 12; j++) {
						if (cycle[j].equals(b)) {
							return dif;
						} else {
							dif++;
						}
					}
				// search backwards if a is younger than b
				} else {
					dif--;
					for (int j = i - 1; j >= 0; j--) {
						if (cycle[j].equals(b)) {
							return dif;
						} else {
							dif--;
						}
					}
					for (int j = 11; j >= 0; j--) {
						if (cycle[j].equals(b)) {
							return dif;
						} else {
							dif--;
						}
					}
				}
				break;
			}
		}
		return -1;
	}
}