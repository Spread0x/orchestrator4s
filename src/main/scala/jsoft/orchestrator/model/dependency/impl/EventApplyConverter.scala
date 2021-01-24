package jsoft.orchestrator.model.dependency.impl

import jsoft.orchestrator.model.dependency.ApplyConverter
import jsoft.orchestrator.model.event.Event

trait EventApplyConverter {

  implicit def a0: ApplyConverter[Unit, Event] {type In = () => Event} = new ApplyConverter[Unit, Event] {

    type In = () => Event

    override def apply(in: In): Unit => Event = {
      _ => in()
    }
  }

  implicit def a1[T1]: ApplyConverter[Tuple1[T1], Event] {type In = T1 => Event} = new ApplyConverter[Tuple1[T1], Event] {

    type In = T1 => Event

    override def apply(in: In): Tuple1[T1] => Event = {
      a => in(a._1)
    }
  }

  implicit def a2[T1, T2]: ApplyConverter[(T1, T2), Event] {type In = (T1, T2) => Event} = new ApplyConverter[(T1, T2), Event] {

    type In = (T1, T2) => Event

    override def apply(in: In): ((T1, T2)) => Event = {
      a => in(a._1, a._2)
    }
  }

  implicit def a3[T1, T2, T3]: ApplyConverter[(T1, T2, T3), Event] {type In = (T1, T2, T3) => Event} = new ApplyConverter[(T1, T2, T3), Event] {

    type In = (T1, T2, T3) => Event

    override def apply(in: In): ((T1, T2, T3)) => Event = {
      a => in(a._1, a._2, a._3)
    }
  }

  implicit def a4[T1, T2, T3, T4]: ApplyConverter[(T1, T2, T3, T4), Event] {type In = (T1, T2, T3, T4) => Event} = new ApplyConverter[(T1, T2, T3, T4), Event] {

    type In = (T1, T2, T3, T4) => Event

    override def apply(in: In): ((T1, T2, T3, T4)) => Event = {
      a => in(a._1, a._2, a._3, a._4)
    }
  }

  implicit def a5[T1, T2, T3, T4, T5]: ApplyConverter[(T1, T2, T3, T4, T5), Event] {type In = (T1, T2, T3, T4, T5) => Event} = new ApplyConverter[(T1, T2, T3, T4, T5), Event] {

    type In = (T1, T2, T3, T4, T5) => Event

    override def apply(in: In): ((T1, T2, T3, T4, T5)) => Event = {
      a => in(a._1, a._2, a._3, a._4, a._5)
    }
  }

  implicit def a6[T1, T2, T3, T4, T5, T6]: ApplyConverter[(T1, T2, T3, T4, T5, T6), Event] {type In = (T1, T2, T3, T4, T5, T6) => Event} = new ApplyConverter[(T1, T2, T3, T4, T5, T6), Event] {

    type In = (T1, T2, T3, T4, T5, T6) => Event

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6)) => Event = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6)
    }
  }

  implicit def a7[T1, T2, T3, T4, T5, T6, T7]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7), Event] {type In = (T1, T2, T3, T4, T5, T6, T7) => Event} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7), Event] {

    type In = (T1, T2, T3, T4, T5, T6, T7) => Event

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7)) => Event = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7)
    }
  }

  implicit def a8[T1, T2, T3, T4, T5, T6, T7, T8]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8), Event] {type In = (T1, T2, T3, T4, T5, T6, T7, T8) => Event} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8), Event] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8) => Event

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8)) => Event = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8)
    }
  }

  implicit def a9[T1, T2, T3, T4, T5, T6, T7, T8, T9]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9), Event] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9) => Event} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9), Event] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9) => Event

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9)) => Event = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9)
    }
  }

  implicit def a10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), Event] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) => Event} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), Event] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) => Event

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)) => Event = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10)
    }
  }

  implicit def a11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), Event] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) => Event} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), Event] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) => Event

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)) => Event = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11)
    }
  }

  implicit def a12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), Event] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) => Event} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), Event] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) => Event

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)) => Event = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12)
    }
  }

  implicit def a13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), Event] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) => Event} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), Event] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) => Event

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)) => Event = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13)
    }
  }

  implicit def a14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), Event] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) => Event} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), Event] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) => Event

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)) => Event = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14)
    }
  }

  implicit def a15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), Event] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) => Event} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), Event] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) => Event

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)) => Event = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15)
    }
  }

  implicit def a16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), Event] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) => Event} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), Event] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) => Event

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)) => Event = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15, a._16)
    }
  }

  implicit def a17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), Event] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) => Event} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), Event] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) => Event

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)) => Event = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15, a._16, a._17)
    }
  }

  implicit def a18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), Event] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) => Event} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), Event] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) => Event

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)) => Event = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15, a._16, a._17, a._18)
    }
  }

  implicit def a19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), Event] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) => Event} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), Event] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) => Event

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)) => Event = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15, a._16, a._17, a._18, a._19)
    }
  }

  implicit def a20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), Event] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) => Event} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), Event] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) => Event

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)) => Event = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15, a._16, a._17, a._18, a._19, a._20)
    }
  }

  implicit def a21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), Event] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) => Event} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), Event] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) => Event

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)) => Event = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15, a._16, a._17, a._18, a._19, a._20, a._21)
    }
  }

  implicit def a22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22), Event] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) => Event} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22), Event] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) => Event

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22)) => Event = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15, a._16, a._17, a._18, a._19, a._20, a._21, a._22)
    }
  }

}
