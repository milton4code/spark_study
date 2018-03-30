package com.milton.spark.streaming

import org.apache.spark.streaming.{Seconds, StreamingContext}

object SocketTextStreamDemo  extends App {

  val ssc = new StreamingContext("local", "NetworkWordCount", Seconds(2))
  val lines = ssc.socketTextStream("localhost", 29999)
  println("lines==============")
  // Split each line into words
  val words = lines.flatMap(_.split(" "))
  // Count each word in each batch
  val pairs = words.map(word => (word, 1))
  val wordCounts = pairs.reduceByKey(_ + _)
  // Print a few of the counts to the console
  wordCounts.print()

  ssc.start()             // Start the computation
  ssc.awaitTermination()  // Wait for the computation to terminate
}
