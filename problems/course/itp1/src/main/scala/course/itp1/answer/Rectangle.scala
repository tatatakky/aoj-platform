package course.itp1.answer

import cats.Applicative

class Rectangle[F[_]](implicit F: Applicative[F]) {
  def program(a: Int, b: Int): F[(Int, Int)] =
    F.ifA( constraints(a, b) )( F.map2( area(a, b), length(a, b) )( (_, _) ),  F.pure[ (Int, Int) ]( (0, 0) ) )

  private def area(a: Int, b: Int): F[Int] = F.pure[Int]( a * b )

  private def length(a: Int, b: Int): F[Int] = F.pure[Int]( 2 * (a + b) )

  def constraints(a: Int, b: Int): F[Boolean] = F.pure[Boolean]( ( 1 <= a && a <= 100 ) && ( 1 <= b && b <= 100 ) )

}
