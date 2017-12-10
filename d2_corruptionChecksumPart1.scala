// what to read
val inputPath = "d2.txt"

// read the file and get into a decent format
val input = {
    scala.io.Source.fromFile(inputPath)
        .mkString
        .split("\n")
        .map{row => row.split("\\s+").map{str => str.trim.toInt}}
}
// get row min and max, then diff, then collapse into the answer
val checksum = { input.map{row => (row.min, row.max)}
    .map{case(min, max) => (min, max, max - min)}
    .map{case(x,y,z) => z}.reduce{_ + _}
}
// display the solution
println(checksum)

