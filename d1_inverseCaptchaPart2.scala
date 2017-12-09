// still not doing a one liner because this isnt golf

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

// need the length and half the length to slice
val length = input.length

// split list is here; careful of zero index
val solution = { input
    .slice(0, length/2) 
    .zip(input.slice(length/2, length))
    .filter{case(x,y) => x == y}
    .map{case(x,y) => x}
    .sum
}*2
// print because I want to go to bed and i heard good code comments itself 
println(solution)
