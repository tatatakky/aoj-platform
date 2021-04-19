package course.itp1.answer

import cats.Monad
import cats.implicits._

class XCubic[F[_]](implicit F: Monad[F]) {
  def program(x: Int): F[Int] =
    for {
      bool <- constraints(x)
      res  <- if(bool) cube(x) else zero
    } yield res

  private def cube(v: Int): F[Int]    = F.pure[Int]( v*v*v )
  private def zero: F[Int]            = F.pure[Int]( 0 )
  def constraints(x: Int): F[Boolean] = F.pure[Boolean]( 1 <= x && x <= 100 )
}