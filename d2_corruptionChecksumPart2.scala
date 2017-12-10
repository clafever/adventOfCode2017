// what to read
val inputPath = "d2.txt"

// read the file and get into an array of lists for cons below
val input = {
    scala.io.Source.fromFile(inputPath)
        .mkString
        .split("\n")
        .map{row => row.split("\\s+").map{str => str.trim.toInt}}
        .map{arr => arr.toList}
}

// tail-rec voodoo. Might be crap but it works?
def checkList(l: List[Int]) = {
    val sl = l.sorted.reverse 
    def innerCheck(sl: List[Int], tmem: List[Int]): Tuple2[Int, Int] = { sl 
        match {
            case x :: List() => innerCheck(tmem, tmem.tail)
            case x :: xs => if (x % xs.head == 0 ){ (x, xs.head) } else innerCheck(x::xs.tail, tmem)
            case Nil => (0,0)
        }
    }
    innerCheck(sl, sl.tail)
}

// yuh
val solution = { input
    .map{row => checkList(row)}
    .map{case(n,d) => n/d}
    .sum
}

println(solution)