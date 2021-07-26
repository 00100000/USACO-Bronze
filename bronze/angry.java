import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

class angry {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("angry.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));

		int n = Integer.parseInt(br.readLine());
		int[] bales = new int[n];

		for (int i = 0; i < n; i++) {
			bales[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bales);
		// simulate shooting each bale
		int max = 0;
		int lastBale = 0;
		boolean contCycle = false;
		for (int i = 0; i < n; i++) {
			int exploded = 1;
			lastBale = bales[i];
			contCycle = false;
			// blasts for all bales under j
			for (int j = i - 1, radius = 1; j >= 0; j--) {
				if (lastBale - bales[j] <= radius) {
					exploded++;
					contCycle = true;
				// if blast can't reach any further but did reach earlier bales
				} else if (contCycle) {
					radius++;
					// reset j to earlier bale
					j++;
					lastBale = bales[j];
					// reset contCycle to see if the next blast continues a chain reaction
					contCycle = false;
				} else {
					break;
				}
			}
			// blasts for all bales over j
			lastBale = bales[i];
			contCycle = false;
			for (int j = i + 1, radius = 1; j < n; j++) {
				if (bales[j] - lastBale <= radius) {
					exploded++;
					contCycle = true;
				} else if (contCycle) {
					radius++;
					j--;
					lastBale = bales[j];
					contCycle = false;
				} else {
					break;
				}
			}
			if (max < exploded) max = exploded;
		}

		pw.println(max);
		br.close();
		pw.close();
	}
}