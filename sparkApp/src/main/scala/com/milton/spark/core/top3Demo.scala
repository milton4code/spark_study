package com.milton.spark.core

import org.apache.spark.{SparkConf, SparkContext}

/**
  * top3
  * Created by milton on 2016/12/2.
  */
object top3Demo extends App {
  val sparkConf = new SparkConf().setMaster("local[*]").setAppName("SecondSortDemo")
  val sc = new SparkContext(sparkConf)
  val lines = sc.textFile("D:/tmp/top.txt")
  lines.map(line => (line.toInt, line)).sortByKey(false)
    .map(sordPair => sordPair._1)
    .take(3)
    .foreach(println)

}
