package scala.compiletime.testing

/** An error can be either a parse-time or a typecheck-time */
sealed trait ErrorKind // This should be an enum but currently, Dotty lib fails to
                       // compile with an obscure error.
object ErrorKind with
  case object Parser extends ErrorKind
  case object Typer extends ErrorKind
