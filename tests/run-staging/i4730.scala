import scala.quoted._
import scala.quoted.staging._

object Test {
  given Compiler = Compiler.make(getClass.getClassLoader)
  def ret(using Quotes): Expr[Int => Int] = '{ (x: Int) =>
    ${
      val z = run('{x + 1}) // throws scala.quoted.runtime.impl.ScopeException =>
      Expr(z)
    }
  }
  def main(args: Array[String]): Unit = {
    scala.mytest.myTest()
  }
}

package scala {
  package mytest {
    def myTest()(using Compiler) = {
      try {
        run(Test.ret).apply(10)
        throw new Exception
      } catch {
        case ex: Exception if ex.getClass.getName == "scala.quoted.runtime.impl.ScopeException" =>
          // ok
      }
    }
  }
}
