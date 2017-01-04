package io.github.jackcviers.functorInstances

import cats.Functor
import org.scalatest._
import org.typelevel.discipline.scalatest.Discipline
import cats.instances.all._
import cats.laws.discipline.arbitrary._
import cats.laws.discipline.FunctorTests
import SeqFunctorInstances._

class SeqFunctorInstancesSpec extends FunSuite with Discipline with Matchers{
  checkAll("Functor[Seq[Int]]", FunctorTests[Seq].functor[Int, Int, Int])

  test("should be useable in a generic function"){
    def usesSeqFunctor(g: Seq[Char])(implicit fSeq: Functor[Seq]): Seq[Int] = fSeq.map(g) { _.toInt}

    usesSeqFunctor("Hayooo") shouldBe Seq(72, 97, 121, 111, 111, 111)
  }
}
