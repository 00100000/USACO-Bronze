#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	vector<int> g(0);
	vector<int> l(0);
	for (int i = 0; i < n; i++) {
		char type;
		int num;
		cin >> type >> num;

		if (type == 'G') {
			g.push_back(num);
		} else {
			l.push_back(num);
		}
	}
	sort(g.begin(), g.end());
	sort(l.begin(), l.end());
	// count the amount of cows the highest g and lowest l disagree with, and remove the highest one
	int removals = 0;
	for (int i = 0; i < n; i++) {
		int gDis = 0, lDis = 0;
		for (int j = 0; j < l.size(); j++) {
			if (g[g.size() - 1] > l[j]) gDis++;
		}
		for (int j = 0; j < g.size(); j++) {
			if (l[0] < g[j]) lDis++;
		}

		if (gDis == 0 && lDis == 0) {
			break;
		}
		if (gDis >= lDis) {
			g.erase(g.begin() + g.size() - 1);
		} else {
			l.erase(l.begin());
		}
		removals++;
	}

	cout << removals;
	return 0;
}
