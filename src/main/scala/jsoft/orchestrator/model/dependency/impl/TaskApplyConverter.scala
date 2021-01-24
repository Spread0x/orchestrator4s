package jsoft.orchestrator.model.dependency.impl

import jsoft.orchestrator.model.dependency.ApplyConverter
import jsoft.orchestrator.model.task.Task

trait TaskApplyConverter {

  implicit def a0: ApplyConverter[Unit, Task] {type In = () => Task} = new ApplyConverter[Unit, Task] {

    type In = () => Task

    override def apply(in: In): Unit => Task = {
      _ => in()
    }
  }

  implicit def a1[T1]: ApplyConverter[Tuple1[T1], Task] {type In = T1 => Task} = new ApplyConverter[Tuple1[T1], Task] {

    type In = T1 => Task

    override def apply(in: In): Tuple1[T1] => Task = {
      a => in(a._1)
    }
  }

  implicit def a2[T1, T2]: ApplyConverter[(T1, T2), Task] {type In = (T1, T2) => Task} = new ApplyConverter[(T1, T2), Task] {

    type In = (T1, T2) => Task

    override def apply(in: In): ((T1, T2)) => Task = {
      a => in(a._1, a._2)
    }
  }

  implicit def a3[T1, T2, T3]: ApplyConverter[(T1, T2, T3), Task] {type In = (T1, T2, T3) => Task} = new ApplyConverter[(T1, T2, T3), Task] {

    type In = (T1, T2, T3) => Task

    override def apply(in: In): ((T1, T2, T3)) => Task = {
      a => in(a._1, a._2, a._3)
    }
  }

  implicit def a4[T1, T2, T3, T4]: ApplyConverter[(T1, T2, T3, T4), Task] {type In = (T1, T2, T3, T4) => Task} = new ApplyConverter[(T1, T2, T3, T4), Task] {

    type In = (T1, T2, T3, T4) => Task

    override def apply(in: In): ((T1, T2, T3, T4)) => Task = {
      a => in(a._1, a._2, a._3, a._4)
    }
  }

  implicit def a5[T1, T2, T3, T4, T5]: ApplyConverter[(T1, T2, T3, T4, T5), Task] {type In = (T1, T2, T3, T4, T5) => Task} = new ApplyConverter[(T1, T2, T3, T4, T5), Task] {

    type In = (T1, T2, T3, T4, T5) => Task

    override def apply(in: In): ((T1, T2, T3, T4, T5)) => Task = {
      a => in(a._1, a._2, a._3, a._4, a._5)
    }
  }

  implicit def a6[T1, T2, T3, T4, T5, T6]: ApplyConverter[(T1, T2, T3, T4, T5, T6), Task] {type In = (T1, T2, T3, T4, T5, T6) => Task} = new ApplyConverter[(T1, T2, T3, T4, T5, T6), Task] {

    type In = (T1, T2, T3, T4, T5, T6) => Task

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6)) => Task = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6)
    }
  }

  implicit def a7[T1, T2, T3, T4, T5, T6, T7]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7), Task] {type In = (T1, T2, T3, T4, T5, T6, T7) => Task} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7), Task] {

    type In = (T1, T2, T3, T4, T5, T6, T7) => Task

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7)) => Task = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7)
    }
  }

  implicit def a8[T1, T2, T3, T4, T5, T6, T7, T8]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8), Task] {type In = (T1, T2, T3, T4, T5, T6, T7, T8) => Task} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8), Task] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8) => Task

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8)) => Task = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8)
    }
  }

  implicit def a9[T1, T2, T3, T4, T5, T6, T7, T8, T9]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9), Task] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9) => Task} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9), Task] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9) => Task

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9)) => Task = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9)
    }
  }

  implicit def a10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), Task] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) => Task} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), Task] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) => Task

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)) => Task = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10)
    }
  }

  implicit def a11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), Task] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) => Task} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), Task] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) => Task

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)) => Task = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11)
    }
  }

  implicit def a12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), Task] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) => Task} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), Task] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) => Task

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)) => Task = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12)
    }
  }

  implicit def a13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), Task] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) => Task} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), Task] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) => Task

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)) => Task = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13)
    }
  }

  implicit def a14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), Task] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) => Task} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), Task] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) => Task

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)) => Task = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14)
    }
  }

  implicit def a15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), Task] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) => Task} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), Task] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) => Task

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)) => Task = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15)
    }
  }

  implicit def a16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), Task] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) => Task} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), Task] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) => Task

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)) => Task = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15, a._16)
    }
  }

  implicit def a17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), Task] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) => Task} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), Task] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) => Task

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)) => Task = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15, a._16, a._17)
    }
  }

  implicit def a18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), Task] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) => Task} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), Task] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) => Task

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)) => Task = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15, a._16, a._17, a._18)
    }
  }

  implicit def a19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), Task] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) => Task} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), Task] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) => Task

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)) => Task = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15, a._16, a._17, a._18, a._19)
    }
  }

  implicit def a20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), Task] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) => Task} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), Task] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) => Task

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)) => Task = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15, a._16, a._17, a._18, a._19, a._20)
    }
  }

  implicit def a21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), Task] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) => Task} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), Task] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) => Task

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)) => Task = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15, a._16, a._17, a._18, a._19, a._20, a._21)
    }
  }

  implicit def a22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]: ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22), Task] {type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) => Task} = new ApplyConverter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22), Task] {

    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) => Task

    override def apply(in: In): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22)) => Task = {
      a => in(a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13, a._14, a._15, a._16, a._17, a._18, a._19, a._20, a._21, a._22)
    }
  }

}
