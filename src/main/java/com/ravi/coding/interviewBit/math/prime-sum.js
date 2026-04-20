'use strict';

/*
 * Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
 * 
 NOTE A solution will always exist. read Goldbach’s conjecture
 
 Example:
 
 
 Input : 4
 Output: 2 + 2 = 4
 
 If there are more than one solutions possible, return the lexicographically smaller solution.
 
 If [a, b] is one solution with a <= b,
 and [c,d] is another solution with c <= d, then
 
 [a, b] < [c, d] 
 
 If a < c OR a==c AND b < d. 
 */


// returns all Prime-Numbers till "n"
// complexity: O(nLogLog(n))
function getPrimeNumber(n) {
	var x = [];

	x[0] = x[1] = 0;
	x[2] = 1;

	for (var i=2; i<=n; i++) {
		x[i] = 1;
	}

	for (var i=2; i*i<=n; i++) {
		if (x[i]==1) {
			for (var p=2*i; p<=n; p+=i) {
				x[p] = 0;
			}
		}
	}

	return x;
}


// check if given number is Prime or Not
function isPrime(n) {
	for (var i=2; i<=Math.sqrt(n); i++) {
		if (n%i == 0) {
			return false;
		}
	}

	return (n <= 1) ? false : true;
}


var Out = { 
 //param A : integer
 //return a array of integers
    primesum : function(A){

	for (var i = 2; i <= (A/2); i++) {
		if (isPrime(i) && isPrime(A-i)) {
			return [i, A-i];
		}
	}

	return [];
    }
};

console.log(Out.primesum(20));

