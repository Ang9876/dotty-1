
import scala.quoted._
import scala.quoted.staging._

object Test {

  given Compiler = Compiler.make(getClass.getClassLoader)

  def main(args: Array[String]): Unit = run {
    def test[T: Type](clazz: java.lang.Class[T]) = {
      val lclazz = Expr(clazz)
      val name = '{ ($lclazz).getCanonicalName }
      println(name.show)
      '{ println($name) }
    }

    '{
      ${test(classOf[Float])}
      ${test(classOf[Double])}
      ${test(classOf[Unit])}
    }
  }

}
