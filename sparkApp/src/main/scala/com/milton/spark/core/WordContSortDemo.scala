package com.milton.spark.core

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by milton on 2016/12/2.
  */
object WordContSortDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("accumulatorVariable")
    val sc = new SparkContext(sparkConf)
    val lines = sc.textFile("C:\\Users\\Administrator\\Desktop\\data.txt")
    lines.flatMap(line => line.split(",")).map(word=>(word,1))
      .reduceByKey(_+_)
      .map(wordCount=> (wordCount._2,wordCount._1))
      .sortByKey(false)
      .foreach(sordWord=>println(sordWord._2+" " +sordWord._1))
  }

}
