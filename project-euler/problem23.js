/**
 * Problem #23
 * Non-abundant sums
 * 
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */
var utils = require('../utils');

 function findNonAbundantSums(){
    var abundantNumbers = utils.findAbundantNumbers(28123)
    var abundantNumbersSet = new Set(abundantNumbers);
    var total=0, isAbundantSum = false;
    //as per description, all integers greater than 28123 can be 
    //written as the sum of two abundant numbers.
    for(var i = 1 ; i <= 28123; i++){
        isAbundantSum = false;
        for(var j= 0;j < abundantNumbers.length; j++){
            if(abundantNumbersSet.has(i - abundantNumbers[j])){
                isAbundantSum = true;
                break;
            }
        }
        if(!isAbundantSum){
            total += i;
        }
    }
    return total;
 }

 console.log(findNonAbundantSums());