package com.milton.spark.scala.clazz

/*
主要演示类的getter/setter方法
 */
class Student {
  // 声明age属性，默认生成get\set方法，同时默认age是private
  var age = 0

  //私有的变量只有getter方法没有setter方法
  // private[this]只能在当前class中使用，不能在其它方法中使用
  private[this] var privateWeight = 120

  // val private[this]修饰的变量只能当前类使用
  var name = "Scala";

  def weight = privateWeight

  // 添加 private [this] 关键字后只在本类中使用
  // def isFat(other:Student) = privateWeight < other.privateWeight;
}