#include <stdio.h>
#define false 0
#define true 1
int n;
int list[15];
int result = 0;

void N_Queen(int cnt);
int ABLE(int i);

int main(void)
{
	scanf("%d", &n);
	N_Queen(0);

	printf("%d", result);
	return 0;
}

void N_Queen(int cnt)
{
	if (cnt == n)
		result += 1;
	else
	{
		for (int j = 0; j < n; j++) {
			list[cnt] = j;
			if (ABLE(cnt)==true)
				N_Queen(cnt + 1);
		}
	}

}

int ABLE(int i)
{
	for (int j = 0; j < i; j++) {
		if (list[j] == list[i] || abs(list[i] - list[j]) == (i - j))
			return false;
	}
	return true;
}