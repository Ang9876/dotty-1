trait Num with
  type Nat

object IsInt with
  def unapply(using num: Num)(sc: num.Nat): Option[Int] = ???

def test(using num: Num)(x: num.Nat) =
  x match
    case IsInt(i) =>
