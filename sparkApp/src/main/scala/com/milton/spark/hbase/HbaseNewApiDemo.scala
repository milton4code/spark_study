package com.milton.spark.hbase

import org.apache.hadoop.hbase.client._
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.hbase.{HBaseConfiguration, HColumnDescriptor, HTableDescriptor, TableName}

import scala.collection.JavaConversions._

/**
  * HBase 1.0.0 新版API, CRUD 的基本操作代码示例
  * create  milton
  * time    2019/10/8 17:18
  */
object HbaseNewApiDemo {


  def main(args: Array[String]): Unit = {
    //    val sc = new SparkContext("local", "SparkHBase")

    System.setProperty("hadoop.home.dir", "E:\\study\\hadoop\\winutils-master\\hadoop-2.6.4")
    //本例将操作的表名
    val conn = getConnection
    val userTable = TableName.valueOf("user")
    val table: Table = conn.getTable(userTable)
    createTable(conn, userTable)

    put(table)
    get(table)
    scan(table)
    delete(table)

  }

  private def delete(table: Table) = {
    //获取 user 表
    try {
      //准备插入一条 key 为 id001 的数据
      val d = new Delete("id001".getBytes)
      //为put操作指定 column 和 value （以前的 put.add 方法被弃用了）
      d.addColumn("basic".getBytes, "name".getBytes)
      //提交
      table.delete(d)

      print("done")
    }
  }

  private def scan(table: Table): Unit = {
    //扫描数据
    val s = new Scan()
    s.addColumn("basic".getBytes, "name".getBytes)
    val scanner = table.getScanner(s)

    try {
      for (r <- scanner) {
        println("Found row: " + r)
        println("Found value: " + Bytes.toString(r.getValue("basic".getBytes, "name".getBytes)))
      }
    } finally {
      //确保scanner关闭
      scanner.close()
    }
  }


  private def get(table: Table): Unit = {

    //查询某条数据
    val g = new Get("id001".getBytes)
    val result = table.get(g)
    val value = Bytes.toString(result.getValue("basic".getBytes, "name".getBytes))
    println("GET id001 :" + value)

  }


  private def put(table: Table) = {
    //获取 user 表
    try {
      //准备插入一条 key 为 id001 的数据
      val p = new Put("id001".getBytes)
      //为put操作指定 column 和 value （以前的 put.add 方法被弃用了）
      p.addColumn("basic".getBytes, "name".getBytes, "wuchong".getBytes)
      //提交
      table.put(p)
      print("done")
    }
  }

  private def createTable(conn: Connection, userTable: TableName) = {
    //从Connection获得 Admin 对象(相当于以前的 HAdmin)
    val admin = conn.getAdmin

    //创建user表
    val tableDescr = new HTableDescriptor(userTable)
    tableDescr.addFamily(new HColumnDescriptor("basic".getBytes()))
    println("create table user")
    //    if (admin.tableExists(userTable)) {
    //      admin.disableTable(userTable)
    //      admin.deleteTable(userTable)
    //    }
    admin.createTable(tableDescr)
    println("Done!")
  }

  private def getConnection = {
    val conf = HBaseConfiguration.create()
    conf.set("hbase.zookeeper.property.clientPort", "2181")
    conf.set("hbase.zookeeper.quorum", "192.168.18.60")

    //Connection 的创建是个重量级的工作，线程安全，是操作hbase的入口
    val conn = ConnectionFactory.createConnection(conf)
    conn
  }
}

