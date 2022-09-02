package sandbox

import org.scalatest.wordspec.AnyWordSpec
import sandbox.CsvEncoder._

// testOnly sandbox.CsvEncoderSpec
class CsvEncoderSpec extends AnyWordSpec {
  val employees: List[Employee] = List(
    Employee("Bill", 1, true),
    Employee("Peter", 2, false),
    Employee("Milton", 3, false)
  )

  val we = writeCsv(employees)
  println(we)

  val iceCreams: List[IceCream] = List(
    IceCream("Sundae", 1, false),
    IceCream("Cornetto", 0, true),
    IceCream("Banana Split", 0, false)
  )

  val wi = writeCsv(iceCreams)
  println(wi)

  println(writeCsv(employees zip iceCreams))
}
