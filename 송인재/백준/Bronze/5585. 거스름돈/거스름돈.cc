#include<iostream>
using namespace std;

int main () {
    int money[6] = {500,100,50,10,5,1};
    int pay;
    cin >> pay;
    int change = 1000 - pay;
    int cnt = 0;

    for (int i = 0; i < 6; i++) {
        cnt = cnt + (change / money[i]);
        change = change - money[i] * (change / money[i]);

        if (change == 0) break;
    }
    
    cout << cnt;
}