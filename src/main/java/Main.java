import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());
		String[] str = sc.nextLine().split(" ");
		int[][] arr = new int[n][2];
		int t = 0;
		for (int i = 0; i < n; i++) {
			arr[i][0] = Integer.parseInt(str[t++]);
			arr[i][1] = Integer.parseInt(str[t++]);
		}

		int[][] temp = new int[1][2];
		for (int i = 0; i < n; i++) {
			int min = i;

			for (int j = i + 1; j < n; j++) {
				if ((arr[min][0] > arr[j][0]) || (arr[i][0] == arr[j][0] && arr[i][1] > arr[j][1])) {
					min = j;
				}
			}

			if (i != min) {
				temp[0][0] = arr[i][0];
				temp[0][1] = arr[i][1];
				arr[i][0] = arr[min][0];
				arr[i][1] = arr[min][1];
				arr[min][0] = temp[0][0];
				arr[min][1] = temp[0][1];
			}
		}

		int count = 0;
		List<Integer> temp_arr = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			temp_arr.add(arr[i][1]);
		}
		for (int i = 0; i < temp_arr.size();) {
			int t1 = temp_arr.get(0);
			for (int j = 0; j < temp_arr.size(); j++) {
				if (t1 < temp_arr.get(j)) {
					t1 = temp_arr.get(j);
					temp_arr.remove(j);
					j--;
				}
			}
			count++;
			temp_arr.remove(i);
		}
		
		System.out.println(count);
		
	}
}
