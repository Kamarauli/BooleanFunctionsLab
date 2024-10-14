#include <iostream>
using namespace std;

int main() {		
		int n;
		int arity;
		cin >> n;
		int numOfInputs[32];
		int inputs[32][32];
		bool truthTables[64][64];
		int leaves[32];
		int numOfLeaves = 0;
		
		for (int i = 0; i < n; i++) {
			cin >> arity;
			numOfInputs[i] = arity;
			if (arity > 0) {
				for (int j = 0; j < arity; j++) {
					cin >> inputs[i][j];
					inputs[i][j]--;
				}
				for (int j = 0; j < (1 << arity); j++) {
					int newInt = 0;
					cin >> newInt;
					truthTables[i][j] = (newInt == 1);
				}
			} else {
				leaves[numOfLeaves++] = i;
			}
		}		

		int depth[n];
		int maxDepth = 0;
		for (int i = 0; i < n; i++) {
			if (numOfInputs[i] > 0) {
				int localMax = 0;
				for (int j = 0; j < numOfInputs[i]; j++) {
					localMax = max(localMax, depth[inputs[i][j]]);
				}
				depth[i] = localMax + 1;
			} else {
				depth[i] = 0;
			}
			maxDepth = max(maxDepth, depth[i]);
		}
		cout << (maxDepth) << endl;
		
		bool evaluate[32];
		for (int arg = 0; arg < (1 << numOfLeaves); arg++) {
			for (int j = 1; j <= numOfLeaves; j++) {
				int xxx = 1 << (numOfLeaves - j);
				evaluate[leaves[j - 1]] = ((arg & xxx) == 0) ? false : true;
			}

			for (int j = 0; j < n; j++) {
				if (numOfInputs[j] == 0) { continue; }
				int value = 0;
				for (int k = 0; k < numOfInputs[j]; k++) {
					value += (evaluate[inputs[j][k]]) ? (1 << (numOfInputs[j] - k - 1)) : 0;
				}
				evaluate[j] = truthTables[j][value];			
			}

			cout << (evaluate[n - 1] ? 1 : 0);
		}				
		return 0;	
}