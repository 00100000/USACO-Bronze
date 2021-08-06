import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class breedflip {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("breedflip.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));

		int n = Integer.parseInt(br.readLine());
		String a = br.readLine();
		String b = br.readLine();

		int flips = 0;
		boolean lastOpposite = false;
		boolean thisOpposite = false;
		// find every sequence of cows that need to be flipped by looking for the break point
		// between sequences of correct cows and incorrect cows
		for (int i = 0; i < n; i++) {
			thisOpposite = a.charAt(i) != b.charAt(i);
			if (thisOpposite && !lastOpposite) flips++;
			lastOpposite = thisOpposite;
		}

		pw.print(flips);
		br.close();
		pw.close();
	}
}
