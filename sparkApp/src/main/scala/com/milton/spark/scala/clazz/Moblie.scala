package com.milton.spark.scala.clazz

/*
主构造函数和辅助构造函数
 */
class Moblie /*主构造函数*/ private /*  private私有构造器*/ (val brand: String, val price: Int) {
  // 定义变量
  var networkType: String = "";

  // 重载构造函数
  def this(brand: String, price: Int, networkType: String) {
    this(brand, price)
//    this.networkType = networkType;
  }
}


