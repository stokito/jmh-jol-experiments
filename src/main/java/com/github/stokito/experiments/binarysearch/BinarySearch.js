/**
 * Find an index of the element in the array haystack with value needle
 * @param {number[]}      haystack array of number elements
 * @param {number} needle needle to find in the haystack
 * @returns {null|number} return index of the element or null if not found
 */
function binarySearch(haystack, needle) {
    var low = 0
    var high = haystack.length - 1
    while (low < high) {
        // average between high and low
        var average = (high - low) / 2
        // round average to integer e.g. 7.5 to 7 so we can use it as array index
        average = Math.floor(average)
        // index of middle element
        var middle = low + average
        var middleValue = haystack[middle]
        if (middleValue == needle) {
            return middle
        } else {
            if (needle > middleValue) {
                low = middle + 1
            } else {
                high = middle - 1
            }
        }
    }
    return null
}

var haystack = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
var index = binarySearch(haystack, 14)
console.log(index)
//=> 14

var indexNotFound = binarySearch(haystack, 16)
console.log(indexNotFound)
//=> null
