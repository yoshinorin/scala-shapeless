package sandbox

case class Employee(name: String, number: Int, manager: Boolean)
case class IceCream(name: String, numCherries: Int, inCone: Boolean)

trait CsvEncoder[A] {
  def encode(value: A): List[String]
}

object CsvEncoder {
  def writeCsv[A](values: List[A])(implicit enc: CsvEncoder[A]): String = values.map(value => enc.encode(value).mkString(",")).mkString("\n")

  implicit val employeeEncoder: CsvEncoder[Employee] =
  new CsvEncoder[Employee] {
    def encode(e: Employee): List[String] =
      List(
        e.name,
        e.number.toString,
        if(e.manager) "yes" else "no"
      )
  }

  implicit val iceCreamEncoder: CsvEncoder[IceCream] =
    new CsvEncoder[IceCream] {
      def encode(i: IceCream): List[String] =
        List(
          i.name,
          i.numCherries.toString,
          if(i.inCone) "yes" else "no"
        )
    }

  implicit def pairEncoder[A, B](
    implicit
    aEncoder: CsvEncoder[A],
    bEncoder: CsvEncoder[B]
  ): CsvEncoder[(A, B)] =
    new CsvEncoder[(A, B)] {
      def encode(pair: (A, B)): List[String] = {
        val (a, b) = pair
        aEncoder.encode(a) ++ bEncoder.encode(b)
      }
    }
}
