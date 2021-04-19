package course.itp1.answer

import cats.Id
import org.scalacheck.{Prop, Properties}

class XCubicSpec extends Properties("XCubic") {
  val xCubic = new XCubic[Id]
  property("program") = Prop.forAll {
    (x: Int) =>
      if (xCubic.constraints(x)) xCubic.program(x) == x*x*x
      else                       xCubic.program(x) == 0
  }
}