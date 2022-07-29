#include <algorithm>
#include <cassert>
#include <bitset>
#include <deque>
#include <iostream>
#include <climits>
#include <list>
#include <map>
#include <cmath>
#include <numeric>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <utility>
#include <vector>
using namespace std;

#define dbg(x) cout<<(#x)<<": "<<(x)<<endl
#define dbglp(x) cout<<(#x)<<":"<<endl;for(auto z:x)cout<<z<<" ";cout<<endl
typedef long long ll;

void solve() {
	int n;
	cin >> n;
	int asum = 0;
	vector<int> a(n);
	for (int i = 0; i < n; i++) {
		cin >> a[i];
		asum += a[i];
	}

	int minCombines = INT_MAX;
	// edge case
	if (asum == 0) {
		cout << 0 << "\n";
		return;
	}
	for (int i = 1; i <= asum; i++) {
		if (asum % i == 0) {
			bool valid = true;
			int combines = 0;
			int tempSum = 0;
			for (int j = 0; j < n; j++) {
				if (tempSum == i) {
					tempSum = a[j];
				} else if (tempSum < i) {
					combines++;
					tempSum += a[j];
				}
				if (tempSum > i) {
					valid = false;
					break;
				}
			}
			if (valid) {
				minCombines = min(minCombines, combines);
			}
		}
	}
	cout << minCombines - 1 << "\n";
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int t;
	cin >> t;
	while (t-- > 0) solve();
	return 0;
}
