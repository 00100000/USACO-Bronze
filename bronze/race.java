import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class race {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("race.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("race.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		// I tried to make my solution understandable, but it's a bit crazy, so sorry if you can't
		// understand it well
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			// add total dist and speed if bessie kept accelerating until she reached speed x
			int t = x;
			int dist = (x * (x + 1)) / 2;
			int speed = 0;
			// if bessie reaches the finish line before or while she reaches speed x
			if (dist >= k) {
				t = 0;
				dist = 0;
				while (dist < k) {
					t++;
					speed++;
					dist += speed;
				}
			} else {
				// add last step of race when speed descreases back to x
				dist += x;
				t++;
				// add speed to both the start and end of the race to find the max speed bessie
				// can peak during the race
				// leave speed + 1 * 2 room to find if the pyramid has a double peak or single
				// peak
				speed = x;
				while (dist < k - (speed + 1) * 2) {
					speed++;
					dist += speed * 2;
					t += 2;
				}
				// if pyramid has single peak
				if (dist + speed + 1 >= k || dist + speed >= k) {
					t++;
				// double peak
				} else {
					t+= 2;
				}
			}
			pw.println(t);
		}

		br.close();
		pw.close();
	}
}