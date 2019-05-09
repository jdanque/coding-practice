/*
 * Coin sums
 * 
 * Problem 31
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
 * 
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * It is possible to make £2 in the following way:
 * 
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * How many different ways can £2 be made using any number of coins?
 */

function problem31() {
  var target = 200;
  var coins = [1, 2, 5, 10, 20, 50, 100, 200];
  var ways = new Array(coins.length + 1);

  ways[0] = 1;
  for (var i = 0; i < coins.length; i++) {
    for (var j = coins[i]; j <= target; j++) {
      if (ways[j] === undefined) {
        ways[j] = 0;
      }
      ways[j] += ways[j - coins[i]];
    }
  }

  return ways[target];
}

console.log(problem31());
