import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxAngle {

	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader sc = new BufferedReader(isr);

		try {
			int n = Integer.parseInt(sc.readLine());
			double[] angle = new double[n];
			for (int i = 0; i < n; i++) {
				angle[i] = Double.parseDouble(sc.readLine());
			}

			double max_dis = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					double diff = Math.abs(angle[i] - angle[j]);
					if (diff > 180) {
						diff = 360 - diff;
					}
					if (max_dis < diff) {
						max_dis = diff;
					}
				}
			}

			System.out.printf("%.8f\n", max_dis);

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
