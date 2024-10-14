import java.util.Scanner;

public class Task1 {
	public static int isRefl(int[][] rel) {
		for (int i = 0; i < rel.length; i++) {
			if (rel[i][i] == 0) {
				return 0;
			}
		}
		return 1;
	}
	
	public static int isAntiRefl(int[][] rel) {
		for (int i = 0; i < rel.length; i++) {
			if (rel[i][i] == 1) {
				return 0;
			}
		}
		return 1;
	}
	
	public static int isSymm(int[][] rel) {
		for (int i = 0; i < rel.length; i++) {
			for (int j = i; j < rel.length; j++) {
				if (rel[i][j] + rel[j][i] == 1) {
					return 0;
				}
			}
		}
		return 1;
	}
	
	public static int isAntiSymm(int[][] rel) {
		for (int i = 0; i < rel.length; i++) {
			for (int j = i; j < rel.length; j++) {
				if ((rel[i][j] + rel[j][i] == 2) && (i != j)) {
					return 0;
				}
			}
		}
		return 1;
	}
	
	public static int isTrans(int[][] rel) {
		for (int i = 0; i < rel.length; i++) {
			for (int j = 0; j < rel.length; j++) {
				for (int k = 0; k < rel.length; k++) {
					if (rel[i][j] + rel[j][k] == 2 && rel[i][k] == 0) {
						return 0;
					}
				}
			}
		}
		return 1;
	}
	
	public static int[][] composition(int[][] rel1, int[][] rel2) {
		int[][] result = new int[rel1.length][rel1.length];
		for (int i = 0; i < rel1.length; i++) {
			for (int j = 0; j < rel1.length; j++) {
				for (int k = 0; k < rel1.length; k++) {
					if (rel1[i][j] + rel2[j][k] == 2) {
						result[i][k] = 1;
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] rel1 = new int[n][n];
		int[][] rel2 = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rel1[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rel2[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		System.out.println(isRefl(rel1) + " " + isAntiRefl(rel1) + " " + isSymm(rel1) + " " + isAntiSymm(rel1) + " " + isTrans(rel1));
		System.out.println(isRefl(rel2) + " " + isAntiRefl(rel2) + " " + isSymm(rel2) + " " + isAntiSymm(rel2) + " " + isTrans(rel2));
		int[][] composition = composition(rel1, rel2);
		for (int[] line : composition) {
			for (int i : line) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
	}
}