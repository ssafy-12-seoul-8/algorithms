#include <stdio.h>

int n, m;
int list[9];
int check[9] = { 0 };

void dfs(int cnt);

int main(void)
{
	scanf("%d %d", &n, &m);

	dfs(0);
	return 0;
}

void dfs(int cnt) {
	if(cnt == m) {
		for (int i = 0; i < m; i++) {
			printf("%d ", list[i]);
		}
		printf("\n");
	}
	
	for (int i = 1; i <= n; i++) {
		if (check[i] != 1) {
			check[i] = 1;
			list[cnt] = i;
			dfs(cnt + 1);
			check[i] = 0;
		}
	}
}