package com.milton.spark.scala.clazz

/*
伴生对象
在Java或C++中即有实例方法又有静态方法。在Scala可以通过类与同名的“伴生”对象来达到同样的目的。
 */

// 伴生类
class ApplyTest() {
  def this(name:String,age:Int){
    this()
  }

  def apply() = println("I am into Spark so much!!!");

  def haveAtry() {
    println("Have a try on apply!");
  }
}

// 伴生对象-apply中的应用
object ApplyTest {
  def apply(): ApplyTest = {
//    println("I am into Scala to much!!!")
    new ApplyTest
  }
}

// 方法调用
object Oop {
  def main(args: Array[String]): Unit = {
    val a = ApplyTest();
    a.haveAtry();
    println(a());

  }
}