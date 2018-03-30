package com.milton.spark.core

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by milton on 2016/12/1.
  */
class ActionOperationDemo {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
      .setAppName("take")
      .setMaster("local")
    val sc = new SparkContext(conf)

    val numberArray = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val numbers = sc.parallelize(numberArray, 1)
    val top3Numbers = numbers.take(3)
    for(num <- top3Numbers) {
      println(num)
    }
  }

}
