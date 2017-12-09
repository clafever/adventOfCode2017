// The captcha requires you to review a sequence of digits (your puzzle input) 
// and find the sum of all digits that match the next digit in the list. 
// The list is circular, so the digit after the last digit is the first digit in the list.

// my solution will be overly verbose for the heck of it

// what to read
val inputPath = "d1.txt"

// read the file and get into a seq
val input: Seq[Int] = {
    // read the file, make it a string, then a seq of chars, then a seq of digits
    scala.io.Source.fromFile(inputPath)
        .mkString
        .map{_.asDigit}
        .toList.toSeq       // stupid vector. should have done list
}

// this will test the pair, if it matches, we record the value
def testPair(x: Int, y: Int): Int = {
    if (x == y) { x }
    else 0
}
// slide over the pairs and do the needful
def reviewSequence(seq: Seq[Int]): Int = {
    // create a sliding Iterator of the pairs in order
    val sliding: Iterator[Seq[Int]] = seq.sliding(2,1)
    // run the tester above to get to zeros and sums
    val tested: Iterator[Int] = sliding.map{ case List(x,y) => testPair(x,y) }
    // reduce it and add the bookends to complete the circle
    val sum: Int = tested.reduce{_+_} + testPair(seq.last, seq.head)
    // return value
    sum
}

println(reviewSequence(input))