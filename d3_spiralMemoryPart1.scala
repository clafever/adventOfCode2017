import math._

// input the number to test
val s = 289326

// closest (higher) odd square, see seq on diagonal bottom right
def nextOddSquare(s: Int): Int = {
    val n = ceil(sqrt(s)).toInt
    n match {
        case 1 => 3
        case even if n%2 == 0 => (n+1)*(n+1)
        case odd => n*n
    }
}
// find how many layers in we are (depth)
def squareIsNthOdd(s: Int): Int = {
    val r = sqrt(s).toInt 
    def acc(n: Int, a: Int): Int = {
        n match {
            case n if (n>1) => acc(n-2, a+1)
            case 1 => a
        }
    }
    acc(r,0)
}
// do some computations
val ns = nextOddSquare(s)                       // what is the nearest odd square (higher)
val distance = ns-s                           // how far is s from that square in steps
val width = sqrt(ns)-1                        // corner to corner distance when stepping
val remainder = distance % width                // how many steps remaining after all turns
val thickness = (width)/2                       // how much mass  is between the "middle" of a leg and the corner
val perimeterMoves = abs(thickness-remainder)   // now we get relative position leftover to get to the "middle of the leg"
val depthMoves = squareIsNthOdd(ns)             // how many "layers" out we are (count of squares)

// show the result
println(perimeterMoves + depthMoves)