package com.milton.spark.scala

class Person {

  private var privateAge = 0
  def age = privateAge
  def age_=(newAge: Int) {
    if (newAge > privateAge) privateAge = newAge
  }

}
object HelloWorld {
  def main(args: Array[String]) {
    var p = new Person()
 /*   p.age = 11
    p.age_=(1) //设置age的值，但是该调用其实相当于调用setter方法，在setter方法中有控制语句，所以该句话不起作用*/
    println(p.age) //取出age的值，相当于getter方法
  }
}