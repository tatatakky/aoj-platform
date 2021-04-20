package course.itp1.answer

import cats.Id
import course.itp1.answer.Rectangle.{InputData, OutputData}
import org.scalacheck.{Prop, Properties}

class RectangleSpec extends Properties("Rectangle"){
  val rectangle = new Rectangle[Id]
  property("program") = Prop.forAll {
    (a: Int, b: Int) =>
      if( rectangle.constraints(InputData(a, b)) ) rectangle.program(InputData(a, b)) == OutputData( (a*b, 2*(a+b)) )
      else                                         rectangle.program(InputData(a, b)) == OutputData( (0, 0) )
  }
}