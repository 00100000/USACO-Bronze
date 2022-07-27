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

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;
	string s;
	cin >> s;

	vector<bool> seq(0);
	for (int i = 0; i < n; i += 2) {
		if (s.at(i) == s.at(i + 1)) continue;
		if (s.at(i) == 'G') seq.push_back(true);
		if (s.at(i) == 'H') seq.push_back(false);
	}
	int cnt = 1;
	for (int i = 1; i < (int)seq.size(); i++) {
		if (seq[i] != seq[i - 1]) cnt++;
	}
	if (!seq[seq.size() - 1]) cnt--;

	cout << cnt;
	return 0;
}

