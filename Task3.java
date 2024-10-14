import java.util.Scanner;

public class Task3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] numOfInputs = new int[n];
		int[][] inputs = new int[n][n];
		boolean[][] truthTables = new boolean[n][n];
		int[] leaves = new int[n];
		int numOfLeaves = 0;
		
		for (int i = 0; i < n; i++) {
			int arity = sc.nextInt();
			numOfInputs[i] = arity;
			if (arity > 0) {
				inputs[i] = new int[arity];
				for (int j = 0; j < arity; j++) {
					inputs[i][j] = sc.nextInt() - 1;
				}
				truthTables[i] = new boolean[1 << arity];
				for (int j = 0; j < (1 << arity); j++) {
					truthTables[i][j] = (sc.nextInt() == 1);
				}
			} else {
				leaves[numOfLeaves++] = i;
			}
		}		
		// глубина
		int[] depth = new int[n];
		int maxDepth = 0;
		for (int i = 0; i < n; i++) {
			if (numOfInputs[i] > 0) {
				int localMax = 0;
				for (int j = 0; j < numOfInputs[i]; j++) {
					localMax = Math.max(localMax, depth[inputs[i][j]]);
				}
				depth[i] = localMax + 1;
			} else {
				depth[i] = 0;
			}
			maxDepth = Math.max(maxDepth, depth[i]);
		}
		System.out.println(maxDepth);
		
		
		// таблица истинности
		boolean[] evaluate = new boolean[n];
		for (int arg = 0; arg < (1 << numOfLeaves); arg++) {
			for (int j = 1; j <= numOfLeaves; j++) {
				int xxx = 1 << (numOfLeaves - j);
				evaluate[leaves[j - 1]] = ((arg & xxx) == 0) ? false : true;
			}
			// листья подсчитали
			for (int j = 0; j < n; j++) {
				if (numOfInputs[j] == 0) { continue; }
				int value = 0;
				for (int k = 0; k < numOfInputs[j]; k++) {
					value += (evaluate[inputs[j][k]]) ? (1 << (numOfInputs[j] - k - 1)) : 0;
				}
				evaluate[j] = truthTables[j][value];			
			}
			System.out.print(evaluate[n - 1] ? 1 : 0);
		}
		
		sc.close();
	}
}
