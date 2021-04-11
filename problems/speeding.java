import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

class speeding {
    public static void main (String[]args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("speeding.in"));
        StringTokenizer t = new StringTokenizer(r.readLine());
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));

        int worstInfraction = 0;

        int n = Integer.parseInt(t.nextToken());
        int m = Integer.parseInt(t.nextToken());

        int[] nArr = new int[100];
        int[] mArr = new int[100];
        // add all values of n by each mile
        int truePosN = 0;
        for (int i = 0; i < n; i++) {
            t = new StringTokenizer(r.readLine());
            int segmentLength = Integer.parseInt(t.nextToken());
            int segmentSpeed = Integer.parseInt(t.nextToken());
            for (int j = 0; j < segmentLength; j++) {
                nArr[truePosN] = segmentSpeed;
                truePosN++;
            }
        }
        // add all values of m by each mile
        int truePosM = 0;
        for (int i = 0; i < m; i++) {
            t = new StringTokenizer(r.readLine());
            int segmentLength = Integer.parseInt(t.nextToken());
            int segmentSpeed = Integer.parseInt(t.nextToken());
            for (int j = 0; j < segmentLength; j++) {
                mArr[truePosM] = segmentSpeed;
                truePosM++;
            }
        }
        // check all values in each array to find worst infraction
        for (int i = 0; i < 100; i++) {
            if (mArr[i] - nArr[i] > worstInfraction) {
                worstInfraction = mArr[i] - nArr[i];
            }
        }
        pw.println(worstInfraction);
        pw.close();
        r.close();
    }
}