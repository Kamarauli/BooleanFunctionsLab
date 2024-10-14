import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Task2 {
	public static int fact(int n) {
		/* if (n == 0) {
			return 1;
		} else {
			return n * fact(n - 1);
		} */
		
		/* for (int i = 2; i <= n; i *= 2) {
			if (n % i == 0) {
				ans += n / i;
			} else {
				break;
			}
		} */
		
		int ans = 0;
		for (int i = 2; i <= n; i += 2) {
			int k = i;
			while (k % 2 == 0) {
				k /= 2;
				ans++;
			}
		}
		return ans;
	}
	
	public static int C(int n, int k) {
		return fact(n) - fact(n - k) - fact(k);
	}
	
	public static boolean savesZero(boolean[] table) {
		return !(table[0]);
	}
	
	public static boolean savesOne(boolean[] table) {
		return table[table.length - 1];
	}
	
	public static boolean isSelfDoubled(boolean[] table) {
		for (int i = 0; i < table.length / 2 + 1; i++) {
			if (table[i] == table[table.length - i - 1]) {
				return false;
			}		
		}
		return true;
	}
	
	public static boolean isLinear(boolean[] table) {
		boolean[][] triangle = new boolean[table.length][table.length];
		for (int i = 0; i < table.length; i++) {
			triangle[i][0] = table[i];
		}
		
		for (int i = 1; i < table.length; i++) {
			for (int j = 0; j < table.length - 1; j++) {
				triangle[j][i] = triangle[j][i - 1] ^ triangle[j + 1][i - 1];
			}
		}
		
		for (int i = 0; i < table.length; i++) {
			if (Integer.bitCount(i) > 1 && triangle[0][i]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isMonotonous(boolean[] table) {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < i; j++) {
				if ((C(i, j) == 0) && !table[i] && table[j]) {
					return false;
				}
			}	
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		boolean[][] table = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			int arity = sc.nextInt();
			table[i] = new boolean[1 << arity];
			String vector = sc.next();
			for (int j = 0; j < (1 << arity); j++) {
				switch (vector.charAt(j)) {
					case '1' : 
						table[i][j] = true;
						break;
					case '0' : 
						table[i][j] = false;
						break;
				}
			}
		}
		sc.close();
		
		boolean[] results = new boolean[5];
		List<String> classes = new ArrayList<String>(Arrays.asList("0", "1", "S", "L", "M"));
		for (int i = 0; i < n; i++) {
			if (!savesZero(table[i])) {classes.remove("0");}
			if (!savesOne(table[i])) {classes.remove("1");}
			if (!isSelfDoubled(table[i])) {classes.remove("S");}
			if (!isLinear(table[i])) {classes.remove("L");}
			if (!isMonotonous(table[i])) {classes.remove("M");}
		}
		
		/* // DEBUG OUTPUT
		System.out.println("----------DEBUG----------");
		for(int i = 0; i < n; i++) {
			for (boolean boo : table[i]) {
				if (boo) {System.out.print("1 ");}
				else {System.out.print("0 ");}
			}
			System.out.println();
		}
		System.out.println();
		
		
		for (String s : classes) {
			System.out.print(s+" ");
		}
		System.out.println();
		System.out.println(fact(31));
		System.out.println(fact(32));

		System.out.println("----------DEBUG-----------"); */
		
		if (classes.isEmpty()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}