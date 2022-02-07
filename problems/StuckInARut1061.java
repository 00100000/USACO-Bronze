import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class StuckInARut1061 {
	static public class Cow {
		int order;
		int x, y;
		int traveled = -1;
	}
	static public class Meet {
		int t, stop;
		int e, n;
		int x, y;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int n = Integer.parseInt(br.readLine());

		ArrayList<Cow> east = new ArrayList<Cow>(0);
		ArrayList<Cow> north = new ArrayList<Cow>(0);
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String dir = st.nextToken();

			Cow c = new Cow();
			c.order = i;
			c.x = Integer.parseInt(st.nextToken());
			c.y = Integer.parseInt(st.nextToken());

			if (dir.equals("E")) east.add(c);
			else north.add(c);
		}
		// construct list of all prospective future meeting points
		ArrayList<Meet> meetings = new ArrayList<Meet>(0);
		for (int i = 0; i < east.size(); i++) {
			for (int j = 0; j < north.size(); j++) {
				int eDif = north.get(j).x - east.get(i).x;
				int nDif = east.get(i).y - north.get(j).y;
				// if cows can overlap and don't both eat the grass at a point
				if (!(east.get(i).x > north.get(j).x || north.get(j).y > east.get(i).y || eDif == nDif)) {
					Meet m = new Meet();
					m.t = Math.max(eDif, nDif);
					m.stop = eDif > nDif ? 1 : 2;
					m.e = i;
					m.n = j;
					m.x = north.get(j).x;
					m.y = east.get(i).y;

					meetings.add(m);
				}
			}
		}
		// sort meeting points by time
		meetings.sort(new Comparator<Meet>() {
			@Override
			public int compare(Meet a, Meet b) {
				return a.t - b.t;
			}
		});
		// check if each meeting is possible
		// (i.e. cows that are supposed to meet haven't been stopped before first reaching the
		// planned meeting point)
		for (int i = 0; i < meetings.size(); i++) {
			Cow eCow = east.get(meetings.get(i).e);
			Cow nCow = north.get(meetings.get(i).n);
			int tempE = eCow.traveled, tempN = nCow.traveled;
			if (tempE == -1) tempE = meetings.get(i).x;
			if (tempN == -1) tempN = meetings.get(i).y;

			if (tempE == meetings.get(i).x) {
				// if both cows aren't stuck and move to meeting point
				if (tempN == meetings.get(i).y) {
					if (meetings.get(i).stop == 1) {
						eCow.traveled = tempE - eCow.x;
					} else {
						nCow.traveled = tempN - nCow.y;
					}
				// if north was stuck but still reached the meeting point before
				} else if (tempN + nCow.y > meetings.get(i).y) {
					eCow.traveled = tempE - eCow.x;
				}
				// if east was stuck but still reached the meeting point before
			} else if (tempN == meetings.get(i).y) {
				if (tempE + eCow.x > meetings.get(i).x) {
					nCow.traveled = tempN - nCow.y;
				}
			}
		}
		// print cows in order
		int ei = 0, ni = 0;
		for (int i = 0; i < n; i++) {
			int ans = -1;
			if (ei < east.size()) if (east.get(ei).order == i) {
				ans = east.get(ei).traveled;
				ei++;
			}
			if (ans == -1 && ni < north.size()) if (north.get(ni).order == i) {
				ans = north.get(ni).traveled;
				ni++;
			}
			pw.println(ans == -1 ? "Infinity" : ans);
		}

		br.close();
		pw.close();
	}
}