package outer
package nested

object indent1 with
  object inner with
    def x: Int = 1
  end inner
  val y: Int = 2
end indent1
