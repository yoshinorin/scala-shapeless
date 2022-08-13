package sandbox

import shapeless._
import org.scalatest.wordspec.AnyWordSpec
import sandbox.MyObject._

// testOnly sandbox.MyObjectSpec
class MyObjectSpec extends AnyWordSpec {


  val genericEmployee = Generic[Employee].to(Employee("Dave", 123, false))
  val genericIceCream = Generic[IceCream].to(IceCream("Sundae", 1, false))

  println(genericEmployee)
  // Dave :: 123 :: false :: HNil
  println(genericIceCream)
  // Sundae :: 1 :: false :: HNil

  println(genericCsv(genericEmployee))
  // List[String] = List(Dave, 123, false)
  println(genericCsv(genericIceCream))
  // List[String] = List(Sundae, 1, false)

  val rect: Shape = Rectangle(3.0, 4.0)
  val circ: Shape = Circle(1.0)

}
