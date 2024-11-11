#include <stdio.h>

int main() {
	int t, m, n, x, y, r;
	int big, small, great, least; //least는 최소공배수, great는 최대공약수
	scanf("%d", &t);

	while (t != 0) { //테스트 넣을 것
		scanf("%d %d %d %d", &m, &n, &x, &y);

		if (m >= n) {
			big = m;
			small = n;
		}
		else if (m < n) {
			big = n;
			small = m;
		}

		while (1)
		{
			if (big % small == 0)
			{
				great = small;
				break;
			}
			else
			{
				r = (big % small);
				big = small;
				small = r;
			}
		}

		least = m * n / great;
		//printf("최대공약수 : %d, 최소공배수 : %d\n", great, least);
		while (1)
		{
			if (x > least || (x - 1) % n + 1 == y)
				break;

			x += m;
		}

		if (x > least)
			printf("-1\n");
		else
			printf("%d\n", x);

		t--;
	}
	return 0;
}