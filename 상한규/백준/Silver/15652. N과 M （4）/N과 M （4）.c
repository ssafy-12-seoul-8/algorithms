#include <stdio.h>

int n, m;
int list[9] = { 0 };
int check[9] = { 0 };

void dfs(int start, int cnt);

int main(void)
{
	scanf("%d %d", &n, &m);

	dfs(1,0);
	return 0;
}

void dfs(int start, int cnt) {
	if (cnt == m) {
		for (int i = 0; i < m; i++) {
			printf("%d ", list[i]);
		}
		printf("\n");
		return;
	}

	for (int i = start; i <= n; i++) {
		
			list[cnt]=i;
			dfs(i,cnt + 1);
	
	}
}