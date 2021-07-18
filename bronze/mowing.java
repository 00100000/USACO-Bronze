import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class mowing {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("mowing.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mowing.out")));

		int n = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		ArrayList<int[]> tiles = new ArrayList<int[]>();

		int x = 0, y = 0;
		int trueT = 0;
		int overlaps = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char direction = st.nextToken().charAt(0);
			int t = Integer.parseInt(st.nextToken());
			for (int j = 0; j < t; j++) {
				if (direction == 'E') {
					x++;
				} else if (direction == 'W') {
					x--;
				} else if (direction == 'N') {
					y++;
				} else {
					y--;
				}
				trueT++;
				int[] pos = {x, y, trueT};
				// check if tile has already been mowed
				for (int k = 0; k < tiles.size(); k++) {
					if (pos[0] == tiles.get(k)[0] && pos[1] == tiles.get(k)[1] && pos[2] - tiles.get(k)[2] < min) {
						min = pos[2] - tiles.get(k)[2];
						overlaps++;
					}
				}
				// track tile
				tiles.add(pos);
			}
		}

		pw.println(overlaps == 0 ? -1 : min);
		br.close();
		pw.close();
	}
}
