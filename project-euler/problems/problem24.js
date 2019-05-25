/**
 * Lexicographic permutations
 * Problem 24
 *
 * A permutation is an ordered arrangement of objects.
 * For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
 * If all of the permutations are listed numerically or alphabetically,
 * we call it lexicographic order.
 * The lexicographic permutations of 0, 1 and 2 are:
 * 012   021   102   120   201   210
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */

var utils = require("../utils");
var result = "";

function findMillionthLexicographicPermutation(str, originalTarget) {
  var numberOfItems = str.length,
    target = originalTarget,
    i;

  var table = [];
  var position = utils.factorial(numberOfItems - 1);

  for (i = 0; i < numberOfItems; i++) {
    table[i] = [];
    table[i][0] = position * i;
    table[i][1] = position - 1 + table[i][0];
  }

  for (k = table.length - 1; k >= 0; k--) {
    if (table[k][0] < target) {
      result += str[k];
      target = target - table[k][0];
      str.splice(k, 1);
      break;
    } else if (table[k][0] == target) {
      result += str[k - 1];
      target = target - table[k - 1][0];
      str.splice(k - 1, 1);
      break;
    }
  }

  if (str.length > 0) {
    findMillionthLexicographicPermutation(str, target);
  }

  return result;
}
