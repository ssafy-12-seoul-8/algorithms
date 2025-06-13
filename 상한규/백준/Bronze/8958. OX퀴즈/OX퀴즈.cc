#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <stdio.h>
#include <string.h>

using namespace std;

int main() {
    int t;
    cin >> t;

    for (int i = 0; i < t; i++) {
        int cont = 1, score = 0;
        char board[80];
        scanf("%s",&board);
        
        int idx = 0;
        while (board[idx] != 0) {
            if (board[idx] == 'O') {
                score+=cont;
                cont++;
                idx++;
            }
            else if (board[idx] == 'X') {
                cont = 1;
                idx++;
            }
        }

        cout << score << endl;

    }



    return 0;
}
