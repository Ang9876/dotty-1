
object Test {
  case class K(i: Int)

  def main(args: Array[String]) = {
    val k = new K(9)
    val is = List(1,2,3)

    is match {
      case List(1, _*,) => // error // error // error: bad use of _* (a sequence pattern must be the last pattern)
                           // illegal start of simple pattern
      case List(1, _*3,) => // error // error: illegal start of simple pattern
      //case List(1, _*3:) =>  // poor recovery by parens
      case List(1, x*) => // error: use _* to match a sequence
      case List(x*, 1) => // error: trailing * is not a valid pattern
      case (1, x*) => // error: trailing * is not a valid pattern
      case (1, x: _*) => // error: bad use of _* (sequence pattern not allowed)
    }

// good syntax, bad semantics, detected by typer
//gowild.scala:14: error: star patterns must correspond with varargs parameters
    val K(x @ _*) = k
    val K(ns @ _*, x) = k // error: bad use of _* (a sequence pattern must be the last pattern)
    val (b, _ : _* ) = (5,6) // error: bad use of _* (sequence pattern not allowed)
// no longer complains
//bad-and-wild.scala:15: error: ')' expected but '}' found.
  }
}

