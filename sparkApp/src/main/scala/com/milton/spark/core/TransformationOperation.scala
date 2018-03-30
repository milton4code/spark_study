package com.milton.spark.core

import org.apache.spark.{SparkConf, SparkContext}

/**
  *
  * Created by milton on 2016/11/30.
  */
object TransformationOperation  {

  /* val sparkConf = new SparkConf().setAppName("demo").setMaster("local")
   val sc = new SparkContext(sparkConf)
   val lineArray = Array("hello@you", "hello@me", "hello@world")
   val lines = sc.parallelize(lineArray,2)
   lines.flatMap(_.split("@")).foreach(println)*/
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("haha")
    val sc = new SparkContext(sparkConf)

    val studentList = Array(Tuple2(1, "leo"),Tuple2(2, "jack"), Tuple2(3, "tom"));
    val scoreList = Array(Tuple2(1, 100),Tuple2(2, 90),Tuple2(4, 60));

    val students = sc.parallelize(studentList);
    val scores = sc.parallelize(scoreList);
    val studentScores = students.join(scores)
    studentScores.foreach(studentScore => {
      println("student id: " + studentScore._1);
      println("student name: " + studentScore._2._1)
      println("student socre: " + studentScore._2._2)
      println("=======================================")
    })

  }

  private def map = {
    val conf = new SparkConf()
      .setAppName("map")
      .setMaster("local")
    val sc = new SparkContext(conf)

    val numbers = Array(1, 2, 3, 4, 5)
    val numberRDD = sc.parallelize(numbers, 1)
    val multipleNumberRDD = numberRDD.map { num => num * 2 }

    multipleNumberRDD.foreach { num => println(num) }


  }
}
