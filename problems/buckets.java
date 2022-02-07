import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class buckets {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("buckets.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));

		int Bx = 0, By = 0, Lx = 0, Ly = 0, Rx = 0, Ry = 0;
		for (int i = 0; i < 10; i++) {
			String s = br.readLine();
			for (int j = 0; j < 10; j++) {
				// track the x and y points of the barn, lake, and rock
				switch (s.charAt(j)) {
					case 'B':
						By = i;
						Bx = j;
						break;
					case 'L':
						Ly = i;
						Lx = j;
						break;
					case 'R':
						Ry = i;
						Rx = j;
						break;
					default:
						break;
				}
			}
		}

		int mod = -1;
		// if rock blocks a direct path to barn
		if (Bx == Lx && Bx == Rx && Math.min(By, Ly) < Ry && Ry < Math.max(By, Ly)) {
			mod = 1;
		} else if (By == Ly && By == Ry && Math.min(Bx, Lx) < Rx && Rx < Math.max(Bx, Lx)) {
			mod = 1;
		}

		pw.print(Math.abs(Bx - Lx) + Math.abs(By - Ly) + mod);
		br.close();
		pw.close();
	}
}
