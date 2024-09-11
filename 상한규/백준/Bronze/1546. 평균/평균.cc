#include <iostream>
#include <vector>
#include <stdio.h>

using namespace std;

int main() {
    double t, n, max = 0, sum = 0;
    vector<int>v(1000, 0);

    cin >> t;

    for (int i = 0; i < t; i++) {
        cin >> n;
        sum += n;
        if (max < n)
            max = n;
    }
    //cout << sum << " " << max<<" "<< sum / max * 100;
    cout.precision(8);
    cout << sum/max*100/t << endl;
    
    /*int idx = 0;
    while (v[idx] != 0) {
        cout << v[idx]<<endl;
        idx++;
    }*/

    return 0;
}
