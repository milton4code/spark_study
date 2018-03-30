package com.milton.spark.core

/**
  * Created by milton on 2016/12/2.
  */
class SecondSortKey(val first :Int,val secend:Int)  extends Ordered[SecondSortKey] with Serializable{
  override def compare(that: SecondSortKey): Int = {
    if (this.first - that.first != 0)
      this.first - that.first
    else
      this.secend - that.secend
  }
}
