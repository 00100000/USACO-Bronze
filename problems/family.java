import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class family {
	static ArrayList<String> mothers = new ArrayList<String>(0);
	static ArrayList<String> daughters = new ArrayList<String>(0);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("family.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("family.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		String a = st.nextToken(), b = st.nextToken();
		// make sure mothers[i] is always the mother of daughter[i]
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String m = st.nextToken(), d = st.nextToken();
			if (daughters.contains(d)) {
				mothers.set(daughters.indexOf(d), m);
			} else {
				mothers.add(m);
				daughters.add(d);
				// if mother's mother is unknown
				if (!daughters.contains(m)) {
					mothers.add("");
					daughters.add(m);
				}
			}
		}
		// if the cows are direct descendents of each other
		if (gensAway(b, a) > 0) {
			String temp = a;
			a = b;
			b = temp;
		}
		int gens = gensAway(a, b);
		if (gens > 0) {
			pw.print(a + " is the ");
			if (gens > 3) {
				for (int i = 2; i < gens; i++) {
					pw.print("great-");
				}
			}
			pw.print((gens >= 2 ? "grand-" : "") + "mother of " + b);
			br.close();
			pw.close();
			return;
		}
		// find the closest common relatives of a and b
		int minADif = 100, minBDif = 100;
		for (int i = 0; i < mothers.size(); i++) {
			if (!mothers.get(i).equals("")) {
				int aDif = gensAway(mothers.get(i), a);
				int bDif = gensAway(mothers.get(i), b);
				// if found relative
				if (aDif > 0 && bDif > 0) {
					// swap so that a comes first in printing
					if (aDif > bDif) {
						int temp = aDif;
						aDif = bDif;
						bDif = temp;

						String tempStr = a;
						a = b;
						b = tempStr;

						temp = minADif;
						minADif = minBDif;
						minBDif = temp;
					}
					minADif = Math.min(minADif, aDif);
					minBDif = Math.min(minBDif, bDif);
				}
			}
		}
		// calculate relation
		if (minADif == 1 && minBDif == 1) {
			pw.print("SIBLINGS");
		} else if (minADif == 1 && minBDif >= 2) {
			pw.print(a + " is the ");
			for (int j = 2; j < minBDif; j++) {
				pw.print("great-");
			}
			pw.print("aunt of " + b);
		} else if (minADif + minBDif == 200) {
			pw.print("NOT RELATED");
		} else {
			pw.print("COUSINS");
		}

		br.close();
		pw.close();
	}
	// returns how many generations a is above b, or -1 if a is not an ancestor of b
	static int gensAway(String a, String b) {
		String nextMother = mothers.get(daughters.indexOf(b));
		for (int i = 1; !nextMother.equals(""); i++) {
			// check if b's mother is a
			if (nextMother.equals(a)) return i;
			// move b higher up the chain
			b = nextMother;
			nextMother = mothers.get(daughters.indexOf(b));
		}
		return -1;
	}
}
