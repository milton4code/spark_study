package com.milton.spark.core

import org.apache.spark.{SparkConf, SparkContext}


/**
  * Created by Administrator on 2016/9/25.
  */
object SimpleApp extends App{
  val logFile = "C:/Users/Administrator/Desktop/README.md" // Should be some file on your system
  val conf = new SparkConf().setAppName("Simple Application").setMaster("local")
  val sc = new SparkContext(conf)
  val logData = sc.textFile(logFile, 2).cache()
  val numAs = logData.filter(line => line.contains("a")).count()
  val numBs = logData.filter(line => line.contains("b")).count()
  println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))



}
