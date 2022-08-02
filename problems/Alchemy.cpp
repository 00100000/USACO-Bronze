#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	ll n, k;
	cin >> n;
	vector<ll> a(n);
	for (ll i = 0; i < n; i++) cin >> a[i];
	cin >> k;
	vector<vector<ll>> adj(n);
	for (ll i = 0; i < k; i++) {
		ll l, m;
		cin >> l >> m;
		l--;
		adj[l].resize(m);
		for (ll j = 0; j < m; j++) {
			cin >> adj[l][j];
			adj[l][j]--;
		}
	}
	// try adding by 100 first. Reduces complexity by 100 times :)
	// extremely scuffed optimization
	ll maxN = a[n - 1];
	// use up all n immediately because micro-optimizations are fun
	a[n - 1] = 0;
	map<ll, ll> needed;
	bool possible = true;
	while (possible) {
		needed = {{n - 1, 100}};
		// scan through the array and get the resources needed for one n
		for (ll i = n - 1; i >= 0; i--) {
			// if you don't have enough of this metal and can make it from children
			if (needed[i] > a[i] && adj[i].size() > 0) {
				for (ll j = 0; j < (ll)adj[i].size(); j++) {
					needed[adj[i][j]] += needed[i] - a[i];
				}
				needed[i] = a[i];
			}
		}
		// use all of those needed resources to make one n
		for (auto i : needed) {
			if (a[i.first] - i.second < 0) possible = false;
		}
		if (possible) {
			for (auto i : needed) {
				a[i.first] -= i.second;
			}
			maxN += 100;
		}
	}
	// add by 1
	needed.clear();
	possible = true;
	while (possible) {
		needed = {{n - 1, 1}};
		// scan through the array and get the resources needed for one n
		for (ll i = n - 1; i >= 0; i--) {
			// if you don't have enough of this metal and can make it from children
			if (needed[i] > a[i] && adj[i].size() > 0) {
				for (ll j = 0; j < (ll)adj[i].size(); j++) {
					needed[adj[i][j]] += needed[i] - a[i];
				}
				needed[i] = a[i];
			}
		}
		// use all of those needed resources to make one n
		for (auto i : needed) {
			a[i.first] -= i.second;
			if (a[i.first] < 0) possible = false;
		}
		if (possible) maxN++;
	}

	cout << maxN;
	return 0;
}
