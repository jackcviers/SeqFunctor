package io.github.jackcviers.functorInstances

import cats.Functor
import cats.kernel.Eq


object SeqFunctorInstances{

  implicit def seqFunctor = new Functor[Seq]{
    def map[A, B](fa: Seq[A])(f: A => B):Seq[B] = fa.map(f)
  }

  implicit def seqEq[A: Eq] = new Eq[Seq[A]]{
    def eqv(x: Seq[A], y:Seq[A]) = x == y
  }
}
