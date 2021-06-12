import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob2_bronze_jan21 {
    public static void main (String[]args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(r.readLine());
        StringTokenizer t = new StringTokenizer(r.readLine());

        int evens = 0;
        int odds = 0;
        // count amount of even and odd cows
        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(t.nextToken()) % 2 == 0) {
                evens++;
            } else {
                odds++;
            }
        }
        if (evens >= odds) {
            System.out.println(odds * 2 + (evens > odds ? 1 : 0));
        } else {
            System.out.println(evens * 2
            // each new odd group of 3 can form an extra even and odd group
            + (odds - evens) / 3 * 2
            // if there's 2 odds left, you can form an extra even group
            + (((odds - evens) % 3 == 2) ? 1 : 0)
            // if there's 1 odd left, it will change the even-ness of a group, making less groups
            - (((odds - evens) % 3 == 1) ? 1 : 0)
            );
        }
    }
}