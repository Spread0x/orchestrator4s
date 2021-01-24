package jsoft.orchestrator.model.dependency

trait JoinInstances {

  implicit def j2[A, B]: Join[Tuple1[A], Tuple1[B]] {type OUT = (A, B)} = new Join[Tuple1[A], Tuple1[B]] {
    type OUT = (A, B)

    override def apply(a: Tuple1[A], b: Tuple1[B]): OUT = (a._1, b._1)
  }

  implicit def j3[T1, T2, T3]: Join[(T1, T2), Tuple1[T3]] {type OUT = (T1, T2, T3)} = new Join[(T1, T2), Tuple1[T3]] {
    type OUT = (T1, T2, T3)

    override def apply(a: (T1, T2), b: Tuple1[T3]): OUT = (a._1, a._2, b._1)
  }

  implicit def j4[T1, T2, T3, T4]: Join[(T1, T2, T3), Tuple1[T4]] {type OUT = (T1, T2, T3, T4)} = new Join[(T1, T2, T3), Tuple1[T4]] {
    type OUT = (T1, T2, T3, T4)

    override def apply(a: (T1, T2, T3), b: Tuple1[T4]): OUT = (a._1, a._2, a._3, b._1)
  }

  implicit def j5[T1, T2, T3, T4, T5]: Join[(T1, T2, T3, T4), Tuple1[T5]] {type OUT = (T1, T2, T3, T4, T5)} = new Join[(T1, T2, T3, T4), Tuple1[T5]] {
    type OUT = (T1, T2, T3, T4, T5)

    override def apply(a: (T1, T2, T3, T4), b: Tuple1[T5]): OUT = (a._1, a._2, a._3, a._4, b._1)
  }

  implicit def j6[T1, T2, T3, T4, T5, T6]: Join[(T1, T2, T3, T4, T5), Tuple1[T6]] {type OUT = (T1, T2, T3, T4, T5, T6)} = new Join[(T1, T2, T3, T4, T5), Tuple1[T6]] {
    type OUT = (T1, T2, T3, T4, T5, T6)

    override def apply(a: (T1, T2, T3, T4, T5), b: Tuple1[T6]): OUT = (a._1, a._2, a._3, a._4, a._5, b._1)
  }

  implicit def j7[T1, T2, T3, T4, T5, T6, T7]: Join[(T1, T2, T3, T4, T5, T6), Tuple1[T7]] {type OUT = (T1, T2, T3, T4, T5, T6, T7)} = new Join[(T1, T2, T3, T4, T5, T6), Tuple1[T7]] {
    type OUT = (T1, T2, T3, T4, T5, T6, T7)

    override def apply(a: (T1, T2, T3, T4, T5, T6), b: Tuple1[T7]): OUT = (a._1, a._2, a._3, a._4, a._5, a._6, b._1)
  }

  implicit def j8[T1, T2, T3, T4, T5, T6, T7, T8]: Join[(T1, T2, T3, T4, T5, T6, T7), Tuple1[T8]] {type OUT = (T1, T2, T3, T4, T5, T6, T7, T8)} = new Join[(T1, T2, T3, T4, T5, T6, T7), Tuple1[T8]] {
    type OUT = (T1, T2, T3, T4, T5, T6, T7, T8)

    override def apply(a: (T1, T2, T3, T4, T5, T6, T7), b: Tuple1[T8]): OUT = (a._1, a._2, a._3, a._4, a._5, a._6, a._7, b._1)
  }

  implicit def j9[T1, T2, T3, T4, T5, T6, T7, T8, T9]: Join[(T1, T2, T3, T4, T5, T6, T7, T8), Tuple1[T9]] {type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9)} = new Join[(T1, T2, T3, T4, T5, T6, T7, T8), Tuple1[T9]] {
    type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9)

    override def apply(a: (T1, T2, T3, T4, T5, T6, T7, T8), b: Tuple1[T9]): OUT = (a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, b._1)
  }

  implicit def j10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]: Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9), Tuple1[T10]] {type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)} = new Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9), Tuple1[T10]] {
    type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)

    override def apply(a: (T1, T2, T3, T4, T5, T6, T7, T8, T9), b: Tuple1[T10]): OUT = (a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, b._1)
  }

  implicit def j11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]: Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), Tuple1[T11]] {type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)} = new Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), Tuple1[T11]] {
    type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)

    override def apply(a: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), b: Tuple1[T11]): OUT = (a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, b._1)
  }

  implicit def j12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]: Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), Tuple1[T12]] {type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)} = new Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), Tuple1[T12]] {
    type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)

    override def apply(a: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), b: Tuple1[T12]): OUT = (a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, b._1)
  }

  implicit def j13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]: Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), Tuple1[T13]] {type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)} = new Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), Tuple1[T13]] {
    type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)

    override def apply(a: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), b: Tuple1[T13]): OUT = (a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, b._1)
  }

  implicit def j14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]: Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), Tuple1[T14]] {type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)} = new Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), Tuple1[T14]] {
    type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)

    override def apply(a: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), b: Tuple1[T14]): OUT = (a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, b._1)
  }

  implicit def j15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]: Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), Tuple1[T15]] {type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)} = new Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), Tuple1[T15]] {
    type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)

    override def apply(a: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), b: Tuple1[T15]): OUT = (a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, b._1)
  }

  implicit def j16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]: Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), Tuple1[T16]] {type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)} = new Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), Tuple1[T16]] {
    type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)

    override def apply(a: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), b: Tuple1[T16]): OUT = (a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15, b._1)
  }

  implicit def j17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]: Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), Tuple1[T17]] {type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)} = new Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), Tuple1[T17]] {
    type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)

    override def apply(a: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), b: Tuple1[T17]): OUT = (a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15, a._16, b._1)
  }

  implicit def j18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]: Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), Tuple1[T18]] {type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)} = new Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), Tuple1[T18]] {
    type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)

    override def apply(a: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), b: Tuple1[T18]): OUT = (a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15, a._16, a._17, b._1)
  }

  implicit def j19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]: Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), Tuple1[T19]] {type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)} = new Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), Tuple1[T19]] {
    type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)

    override def apply(a: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), b: Tuple1[T19]): OUT = (a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15, a._16, a._17, a._18, b._1)
  }

  implicit def j20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]: Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), Tuple1[T20]] {type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)} = new Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), Tuple1[T20]] {
    type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)

    override def apply(a: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), b: Tuple1[T20]): OUT = (a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15, a._16, a._17, a._18, a._19, b._1)
  }

  implicit def j21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]: Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), Tuple1[T21]] {type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)} = new Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), Tuple1[T21]] {
    type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)

    override def apply(a: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), b: Tuple1[T21]): OUT = (a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15, a._16, a._17, a._18, a._19, a._20, b._1)
  }

  implicit def j22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]: Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), Tuple1[T22]] {type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22)} = new Join[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), Tuple1[T22]] {
    type OUT = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22)

    override def apply(a: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), b: Tuple1[T22]): OUT = (a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15, a._16, a._17, a._18, a._19, a._20, a._21, b._1)
  }

}
