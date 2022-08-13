package sandbox

import shapeless._

// ADT OR (余積:coproducts) - seald trait を使う
sealed trait Shape
// ADT AND (積:products) - case class を使う
final case class Rectangle(width: Double, height: Double) extends Shape
final case class Circle(radius: Double) extends Shape

object MyObject {

  case class Employee(name: String, number: Int, manager: Boolean)
  case class IceCream(name: String, numCherries: Int, inCone: Boolean)

  def genericCsv(gen: String :: Int :: Boolean :: HNil): List[String] = {
    List(gen(0), gen(1).toString, gen(2).toString)
  }

  def area(shape: Shape): Double =
    shape match {
      case Rectangle(w, h) => w * h
      case Circle(r)       => math.Pi * r * r
    }
}
