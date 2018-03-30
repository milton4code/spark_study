package com.milton.spark.core

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Administrator on 2016/10/11.
  */

case class Person(name: String, age: Int)

object SQLOnSpark extends App {
  val sparkConf = new SparkConf().setAppName("SQLOnSpark").setMaster("local")
  val sc = new SparkContext(sparkConf)
  val sqlContext = new SQLContext(sc)
  import sqlContext.implicits._
  val people = sc.textFile("hdfs://hadoop1:9000/sogou/people.txt").map(_.split(","))
      .map(p=>Person(p(0),p(1).trim.toInt)).toDF()
  people.registerTempTable("people")
  val teenagers = sqlContext.sql("SELECT name FROM people WHERE age >= 10 and age <= 19")
//  teenagers.map(t => "Name: " + t(0)).collect().foreach(println)
  teenagers.map(t=>"Name:"+t(0)).collect().foreach(println)
  sc.stop
}

