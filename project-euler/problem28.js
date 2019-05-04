/**
 * Number spiral diagonals
 *
 * Problem 28
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
 *
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 *
 * It can be verified that the sum of the numbers on the diagonals is 101.
 *
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 */

function problem28(x) {
  if (x <= 0) return 0;

  var total = 1;
  var diagonal = 1;

  //only odd numbers have proper diagonals
  for (var n = 3; n <= x; n += 2) {
    var diagonalPerLayer = 4;
    while (diagonalPerLayer != 0) {
      diagonal = diagonal + (n - 1);
      total += diagonal;
      diagonalPerLayer--;
    }
  }

  return total;
}

console.log(problem28(1001));
