
/**
 * Sieves' through positive numbers to find the divisors
 * of a number;
 * 
 * @param {Number} n - find the divisors until this number. 
 * @returns An object with a list of divisors and total and its' classification ( perfect, abundant, deficient );
 */
function findDivisors(n) {
    var r = {
        listOfDivisors: new Set([1]),
        total: 1,
        isPerfect: false,
        isAbundant: false,
        isDeficient: false
      },
      half = Math.floor(n / 2);
  
    if (n % 2 == 0) {
      r.listOfDivisors.add(2);
      r.total += 2;
    }
  
    for (var i = 3; i <= half; i++) {
      var skip = false;
      for (const j in r.listOfDivisors.values) {
        if (i % j == 0) {
          skip = true;
          break;
        }
      }
      if (!skip && n % i == 0) {
        r.listOfDivisors.add(i);
        r.total += i;
      }
    }

    if(r.total == n){
        r.isPerfect = true;
    }else if(r.total > n){
        r.isAbundant = true;
    }else{
        r.isDeficient = true;
    }

    return r;
}

/**
 * A number is called abundant if the sum of its proper divisors sum exceeds n.
 * @param {Number} n 
 */
function findAbundantNumbers(n) {
    var numbers = [];
    
    //starting at 12 since 12 is the smallest abundant number.
    for (var i = 12; i <= n; i++) {
      var divisors = findDivisors(i);
      if (divisors.isAbundant) {
        numbers.push(i);
      }
    }
    return numbers;
}

/**
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
 * @param {Number} n 
 */
function findPerfectNumbers(n){
    var numbers = [];
    
    //starting at 6 because it's the smallest perfect number.
    for (var i = 6; i <= n; i++) {
      var divisors = findDivisors(i);
      if (divisors.isPerfect) {
        numbers.push(i);
      }
    }
    return numbers;
}


/**
 * A deficient number is a number for which the sum of its proper divisors is less than the number.
 * @param {Number} n 
 */
function findDeficientNumbers(n){
    var numbers = [];
    
    //starting at 6 because it's the smallest deficient number.
    for (var i = 6; i <= n; i++) {
      var divisors = findDivisors(i);
      if (divisors.isDeficient) {
        numbers.push(i);
      }
    }
    return numbers;
}

module.exports = {
    findDivisors : findDivisors,
    findPerfectNumbers : findPerfectNumbers,
    findAbundantNumbers : findAbundantNumbers,
    findDeficientNumbers : findDeficientNumbers
}