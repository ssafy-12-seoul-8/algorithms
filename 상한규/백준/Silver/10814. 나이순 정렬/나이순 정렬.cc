#include<iostream>
#include<cstring>
#include<string>
#include<vector>
#include<algorithm>

using namespace std;

bool cmp(pair<int, string> a, pair<int, string> b) {
    return a.first < b.first;
}

vector<string> order[201];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int N;
    cin >> N;

    int old;
    string temp;
    for (int i = 0; i < N; i++) {
        cin >> old >> temp;
        order[old].push_back(temp);
    }

    for (int i = 1; i <= 200; i++) {
        for (int j = 0; j < order[i].size(); j++)
            cout << i << " " << order[i][j] << "\n";
    }

    return 0;
}
