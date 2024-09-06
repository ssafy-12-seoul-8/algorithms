#include <iostream>
#include <algorithm>
using namespace std;
#define int int64_t
constexpr int maxScope = 1'000'000;
bool isPrimes[maxScope] = {}; //에라스토테네스의 체 계산을 위한 배열
int primes[maxScope] = {}, psize = 0; //계산된 홀수 소수를 저장할 배열과 그 크기
void calcPrimes() {
	fill(isPrimes, isPrimes + maxScope, true);
	isPrimes[0] = false;
	isPrimes[1] = false;

	for (int prime = 2; prime < maxScope; ++prime) { //에라스토테네스의 체 계산
		if (!isPrimes[prime])
			continue;

		primes[psize++] = prime; //prime은 소수이므로 primes에 저장
		for (int notPrime = 2 * prime; notPrime < maxScope; notPrime += prime)
			isPrimes[notPrime] = false;
	}
}
void solve(int N) {
	for (int p : primes) { //p는 소수임이 보장됨
		if (!isPrimes[N - p]) //골드바흐의 추측을 만족하지 않는 경우
			continue;

		//N = p + N-p 로 골드바흐으 추측을 만족하는 경우
        cout << N << " = " << p << " + " << N - p << "\n";
		break;
	}
}
int32_t main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
	calcPrimes();

	int N;
	while (true) {
		cin >> N;
		if (!N) break;
		solve(N);
	}
}
