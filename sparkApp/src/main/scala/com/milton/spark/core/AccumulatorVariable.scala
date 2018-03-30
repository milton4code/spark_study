package com.milton.spark.core

import org.apache.spark.{SparkConf, SparkContext}

/**
  * 累加器Demo
  * Created by milton on 2016/12/2.
  */
object AccumulatorVariable extends App{
  val sparkConf = new SparkConf().setMaster("local[*]").setAppName("accumulatorVariable")
  val sc = new SparkContext(sparkConf)
  val  sum = sc.accumulator(0)
  val rdd = sc.parallelize(Array(1,2,3,4,6),1)
  val sum0 = rdd.foreach(num => sum += num)
  print(sum0)
}
