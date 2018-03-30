package com.milton.spark.core

import org.apache.spark.{SparkConf, SparkContext}

/**
  * 广播变量小案例
  * Created by milton on 2016/12/2.
  */
object BroadcastDemo {
  def main(args: Array[String]): Unit = {

  }
//广播变量demo
  private def broadCastDemo = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("BroadcastDemo")
    val sc = new SparkContext(sparkConf)
    val factor = 3
    //    val factorBroad = sc.broadcast(factor)
    val rdd = sc.parallelize(Array(1, 2, 3, 4, 5, 6), 1)
    rdd.map(num => num * factor).foreach(println)
  }
}
