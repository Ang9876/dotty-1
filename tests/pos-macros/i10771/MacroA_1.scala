import scala.quoted._

case class MyQuoted(val ast: String, runtimeQuotes: List[String])

object MyQuoteMacro with
  inline def myquote: MyQuoted = ${ MyQuoteMacro.apply }
  def apply(using Quotes): Expr[MyQuoted] =
    '{ MyQuoted("p", ${Expr.ofList(List( '{ "foo" } ))}) }
