enum Outer with
  case Foo
object Outer with
  trait Bar
  case class Baz(bar: Bar)
  case class Bam(bar: Bar = new Bar() {})
