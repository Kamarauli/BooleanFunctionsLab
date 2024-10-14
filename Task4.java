import java.util.Scanner;
import java.util.ArrayList;

public class Task4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int curElemNum = 2 * n + 1;
		ArrayList<Integer> closesEnds = new ArrayList<Integer>();
		ArrayList<int[]> ans = new ArrayList<int[]>();
		
		for (int i = 0; i < (1 << n); i++) {
			String arg = sc.next();
			if (sc.nextInt() == 0) { continue; }
			
			// строим клоз
			int[] closeLieves = new int[n];
			for (int j = 0; j < n; j++) {
				if (arg.charAt(j) == '1') {
					closeLieves[j] = j + 1;
				} else {
					closeLieves[j] = j + 1 + n;
				}
			}
			
			// closeLieves - то, что надо перемножить			
			for (int j = 0; j < n - 1; j++) {
				if (j == 0) { 
					ans.add(new int[]{2, closeLieves[0], closeLieves[1]});
					curElemNum++;
				} else {
					ans.add(new int[]{2, curElemNum++ - 1, closeLieves[j + 1]});
				}
			}
			closesEnds.add(curElemNum - 1);
			
		}
				
		if (closesEnds.size() == 0) {
			ans.add(new int[]{1, 1});
			ans.add(new int[]{2, 1, n + 1});
		} else {
			for (int i = n; i > 0; i--) {
				ans.add(0, new int[]{1, i});
		    }
		}
				
		// теперь надо задизъюнктить то, что в closesEnds		
		for (int j = 0; j < closesEnds.size() - 1; j++) {
			if (j == 0) {
				ans.add(new int[]{3, closesEnds.get(0), closesEnds.get(1)});
				curElemNum++;
			} else {
				ans.add(new int[]{3, curElemNum++ - 1, closesEnds.get(j + 1)});
			}
		}	
		
		System.out.println(ans.size() + n);
		for (int[] elem : ans) {
			for (int num : elem) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}