import java.util.Scanner;

public class Task5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] bitsSets = new String[1 << n];
		int[][] triangle = new int[1 << n][1 << n];
		for (int i = 0; i < (1 << n); i++) {
			bitsSets[i] = sc.next();
			triangle[i][0] = sc.nextInt();
		}
		
		for (int i = 1; i < (1 << n); i++) {
			for (int j = 0; j < (1 << n) - 1; j++) {
				triangle[j][i] = (triangle[j][i - 1] + triangle[j + 1][i - 1]) % 2;
			}
		}
		
		for (int i = 0; i < (1 << n); i++) {
			System.out.println(bitsSets[i] + " " + triangle[0][i]);
		}
		sc.close();
	}
}