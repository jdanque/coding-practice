package problems; /**
 * Quadratic primes
 * Problem 27
 * Euler discovered the remarkable quadratic formula:
 *
 * n2+n+41
 * It turns out that the formula will produce 40 primes for the consecutive integer values 0≤n≤39.
 * However, when n=40,402+40+41=40(40+1)+41 is divisible by 41, and certainly when n=41,412+41+41 is clearly divisible by 41.
 *
 * The incredible formula n2−79n+1601 was discovered, which produces 80 primes for the consecutive values 0≤n≤79.
 * The product of the coefficients, −79 and 1601, is −126479.
 *
 * Considering quadratics of the form:
 *
 * n2+an+b, where |a|<1000 and |b|≤1000
 *
 * where |n| is the modulus/absolute value of n
 * e.g. |11|=11 and |−4|=4
 * Find the product of the coefficients, a and b,
 * for the quadratic expression that produces the maximum number of primes for consecutive values of n,
 * starting with n=0.
 *
 */

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

class problem27{

    private static Set<Integer> primeSieve = new HashSet<>();


    public static void main(String args[]){
        fillSieve();
        System.out.println(findQuadraticPrimes());
    }

    public static void fillSieve(){
        boolean skip = false;
        primeSieve.add(2);

        for(int i = 3; i < 5000;i+=2){
            for (Integer prime : primeSieve) {
                if(i % prime == 0){
                    skip = true;
                    break;
                }
            }
            if(!skip){
                primeSieve.add(i);
            }
            skip=false;
        }
    }

    public static boolean isPrime(int n){
        n = Math.abs(n);
        primeSieve.add(2);
        if(primeSieve.contains(n)){
            return true;
        }

        boolean skip = false;
        for(int i = 3; i <= n; i+=2){
            for (Integer prime : primeSieve) {
                if (i % prime == 0) {
                    skip = true;
                    break;
                }
            }
            if(!skip){
                primeSieve.add(i);
            }
            skip = false;
        }

        return primeSieve.contains(n);
    }

    public static int findQuadraticPrimes(){
        int a,b,n,aMax=0,bMax=0,nMax=0;
        for(a = -1000; a < 1000; a++){
            for(b = -1000; b < 1000; b++){
                if(!isPrime(a) || !isPrime(b)){
                    continue;
                }
                n = 0;
                int x = 2;
                while(isPrime(x)){
                    x = (n * n) + (a * n) + b;
                    n++;
                }
                if(n > nMax){
                    nMax = n;
                    aMax = a;
                    bMax = b;
                }
            }
        }

        return (aMax * bMax);
    }
}