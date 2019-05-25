var NUMBER_NAME = new Set([
  [0, "zero"],
  [1, "one"],
  [2, "two"],
  [3, "three"],
  [4, "four"],
  [5, "five"],
  [6, "six"],
  [7, "seven"],
  [8, "eight"],
  [9, "nine"],
  [10, "ten"],
  [11, "eleven"],
  [12, "twelve"],
  [13, "thirteen"],
  [14, "fourteen"],
  [15, "fifteen"],
  [16, "sixteen"],
  [17, "seventeen"],
  [18, "eighteen"],
  [19, "nineteen"],
  [20, "twenty"],
  [30, "thirty"],
  [40, "forty"],
  [50, "fifty"],
  [60, "sixty"],
  [70, "seventy"],
  [80, "eighty"],
  [90, "ninety"]
]);

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

  if (r.total == n) {
    r.isPerfect = true;
  } else if (r.total > n) {
    r.isAbundant = true;
  } else {
    r.isDeficient = true;
  }

  r.listOfDivisors.add(n);
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
function findPerfectNumbers(n) {
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
function findDeficientNumbers(n) {
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

/**
 * Sort lexically per charater.
 * @param {String} str
 */
function sortLexicalPerChar(str) {
  var charCodeSet = new Map();
  var charCodeSetDuplicates = new Map();
  var r = "",
    high = -1,
    low = Number.MAX_VALUE;

  for (var i = 0; i < str.length; i++) {
    var iCharCode = str.charCodeAt(i);
    charCodeSet.set(iCharCode, str.charAt(i));
    if (charCodeSetDuplicates.has(iCharCode)) {
      charCodeSetDuplicates.set(
        iCharCode,
        charCodeSetDuplicates.get(iCharCode) + 1
      );
    } else {
      charCodeSetDuplicates.set(iCharCode, 1);
    }
    high = high <= iCharCode ? iCharCode : high;
    low = low < iCharCode ? low : iCharCode;
  }

  for (var j = low; j <= high; j++) {
    if (charCodeSet.has(j)) {
      while (charCodeSetDuplicates.get(j) > 0) {
        r += charCodeSet.get(j);
        charCodeSetDuplicates.set(j, charCodeSetDuplicates.get(j) - 1);
      }
    }
  }
  return r;
}

/**
 * Factorial with memoization if used recursively.
 * @param {Number} n
 * @param {Set} memo
 * @returns {Set} factorial(n).getAll - return all factorials from 0 to n
 * @returns {Number} factorial(n).get - returns the factoral of n
 */
function factorial(n, memo = new Map()) {
  if (n <= 1) {
    return 1;
  }
  if (memo.has(n)) {
    return memo.get(n);
  }
  memo.set(n, n * factorial(n - 1, memo));

  return memo.get(n);
}

/**
 * Simple fibonacci generator
 * @param {Number} n
 * @param {Map} memo
 */
function fibonacci(n, memo = new Map()) {
  if (memo.has(n)) return memo.get(n);
  if (n <= 1) {
    memo.set(n, n);
    result = memo.get(n);
  } else {
    memo.set(n, fibonacci(n - 1, memo) + fibonacci(n - 2, memo));
  }

  result = memo.get(n);
  return result;
}

/**
 * Returns the prime factors of a number
 * @param {Number} n
 */
function getPrimeFactors(n) {
  var result = {
    isPrime: true,
    factors: []
  };

  while (n % 2 == 0) {
    result.factors.push(2);
    n /= 2;
  }

  for (var i = 3; i <= Math.sqrt(n); i += 2) {
    while (n % i == 0) {
      result.isPrime = false;
      result.factors.push(i);
      n /= i;
    }
  }

  if (n > 2) {
    result.factors.push(n);
  }

  return result;
}

module.exports = {
  findDivisors,
  findPerfectNumbers,
  findAbundantNumbers,
  findDeficientNumbers,
  sortLexicalPerChar,
  factorial,
  fibonacci,
  getPrimeFactors,
  NUMBER_NAME
};
