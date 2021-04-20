package course.itp1.answer

import cats.Id
import course.itp1.answer.XCubic.{InputData, OutputData}
import org.scalacheck.{Prop, Properties}

class XCubicSpec extends Properties("XCubic") {
  val xCubic = new XCubic[Id]
  property("program") = Prop.forAll {
    (v: Int) =>
      if (xCubic constraints InputData(v)) xCubic.program(InputData(v)) == OutputData( v*v*v )
      else                                 xCubic.program(InputData(v)) == OutputData(0)
  }
}