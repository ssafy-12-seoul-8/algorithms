#include <stdio.h>
#include <math.h>

int main()
{
    int a, b, v, d;
    scanf("%d %d %d", &a, &b, &v);
    d = ceil((v-a)/(double)(a-b)) + 1;
    printf("%d\n", d);
}