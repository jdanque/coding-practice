/**
 *  Digit fifth powers
 *
 * Problem 30
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 *
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
 * As 1 = 1^4 is not a sum it is not included.
 *
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 *
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */

/**
 * the highest possible number which equals the sum of the fifth power of its digits is 5 times 9^5=295245
 */
var digitFifths = [0, 1, 32, 243, 1024, 3125, 7776, 16807, 32768, 59049];

function isDigitFifth(n) {
  var total = 0,
    x = n;

  while (n != 0) {
    total += digitFifths[n % 10];
    if (total > x) {
      return false;
    }
    n = Math.floor(n / 10);
  }

  return total == x;
}

function findDigitFifth() {
  var total = 0;
  for (var i = 2; i < 295245; i++) {
    if (isDigitFifth(i)) {
      total += i;
    }
  }
  return total;
}

console.log(findDigitFifth());
