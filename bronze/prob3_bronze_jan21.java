import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class prob3_bronze_jan21 {
    public static void main (String[]args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t = new StringTokenizer(r.readLine());
        PrintWriter w = new PrintWriter(new OutputStreamWriter(System.out));

        long ret = 1;

        int n = Integer.parseInt(t.nextToken());

        // construct cow and stall array
        int[] cows = new int[n];
        int[] stalls = new int[n];
        // parse each token into an integer
        StringTokenizer cowsString = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            cows[i] = Integer.parseInt(cowsString.nextToken());
        }
        StringTokenizer barnHeightsString = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            stalls[i] = Integer.parseInt(barnHeightsString.nextToken());
        }
        // sort both arrays
        Arrays.sort(cows);
        Arrays.sort(stalls);

        int temp = 0;
        // loop through all indexes of cows
        for (int i = n - 1; i > -1; i--) {
            // loop through all indexes of stalls
            for (int j = i; j > -1; j--) {
                // find lowest stall a cow can fit into, exluding
                // stalls above it that are already taken by higher
                // cows
                if (cows[i] <= stalls[j]) {
                    temp++;
                }
            }
            // multiply it to the answer and reset temp
            ret *= temp;
            temp = 0;
        }

        w.println(ret);
        r.close();
        w.close();
    }
}