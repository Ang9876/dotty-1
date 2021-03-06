package x

trait Printer[T] with
  def print(t:T):String

extension[T](t:T)(using Printer[T])
  def print():String = summon[Printer[T]].print(t)

object A

object B

given Printer[A.type] with
   def print(a:A.type):String = "a"

given Printer[B.type] with
   def print(b:B.type):String = "b"


object Main {

  def main(args:Array[String]):Unit =
    System.out.println(B.print())

}
