package com.milton.spark.scala.clazz

object TestMobile {
  def main(args: Array[String]): Unit ={
    //    // 在构造函数加private修饰，构造函数将不可用
//        var moblie = Moblie("SAMSUNG",4500);
//        moblie.networkType = "三星"
    //
    //    // 在构造函数加private修饰，构造函数将不可用
    //    var moblie = new Moblie("SAMSUNG",4500);
    //    println("品牌："+moblie.brand);
    //
    var moblie2 = new Moblie("SAMSUNG",4500,"3G网络通信")
    println("品牌："+moblie2.brand);
    println("价格："+moblie2.price);
//    println("通信类型："+moblie.networkType);
  }
}
