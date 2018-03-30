package com.milton.spark.core

import org.apache.spark.{SparkConf, SparkContext}

/**
  * 1\ 按照文件中的第一列排序。
  * 2\如果第一列相同，则按照第二列排序。
  * Created by milton on 2016/12/2.
  */
object SecondSortDemo extends App {
  val sparkConf = new SparkConf().setMaster("local[*]").setAppName("SecondSortDemo")
  val sc = new SparkContext(sparkConf)
//  val lines = sc.textFile("/data/tmp/sort.txt")
  val lines = sc.textFile("D:/tmp/sort.txt")
  lines.map(line => (new SecondSortKey(line.split(" ")(0).toInt,line.split(" ")(1)toInt),line))
    .sortByKey()
    .map(sort=>sort._2)
    .foreach(println)
}
