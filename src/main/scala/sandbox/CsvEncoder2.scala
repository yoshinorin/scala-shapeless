package sandbox

package sandbox

case class Employee(name: String, number: Int, manager: Boolean)
case class IceCream(name: String, numCherries: Int, inCone: Boolean)

trait CsvEncoder2[A] {
  def encode(value: A): List[String]
}

object CsvEncoder2 {
  // Summoner (Materializer)
  def apply[A](implicit enc: CsvEncoder2[A]): CsvEncoder2[A] = enc

  // Constructor

  def instance[A](func: A => List[String]): CsvEncoder2[A] =
    new CsvEncoder2[A] {
      def encode(value: A): List[String] = func(value)
    }
}
