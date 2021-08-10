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

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			int t = 0;
			int dist = 0;
			int speed = 0;
			// bessie accelerates until she reaches speed x
			t = 0;
			dist = 0;
			speed = 0;
			while (dist < k && speed <= x) {
				t++;
				speed++;
				dist += speed;
			}
			// if bessie travels above the max speed, add the speeds twice, to simulate when bessie
			// passes that speed in her acceleration and deceleration
			while (dist < k) {
				dist += speed * 2;
				t += 2;
				speed++;
			}
			// if the max speed only needs to be traveled once
			if (dist - speed + 1 >= k) t--;
			pw.println(t);
		}

		br.close();
		pw.close();
	}
}