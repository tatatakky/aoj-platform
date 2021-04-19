package course.itp1.answer

import cats.Id
import org.scalacheck.{Prop, Properties}

class RectangleSpec extends Properties("Rectangle"){
  val rectangle = new Rectangle[Id]
  property("program") = Prop.forAll {
    (a: Int, b: Int) =>
      if(rectangle.constraints(a, b)) rectangle.program(a, b) == ( a*b, 2*(a+b) )
      else                            rectangle.program(a, b) == ( 0,   0)
  }
}