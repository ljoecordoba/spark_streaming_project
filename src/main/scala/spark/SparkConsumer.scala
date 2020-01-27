package spark

import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import aws.S3Writer
import org.apache.spark.SparkConf
import org.apache.spark.streaming.Durations
import org.apache.spark.streaming.api.java.JavaStreamingContext
import org.apache.spark.streaming.kafka010.OffsetRange
import java.util

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.spark.api.java.function.PairFunction

class SparkConsumer {



  System.setProperty("AWS_ACCESS_KEY_ID", "AKIA6CM2WR6UI46RMI5I")
  System.setProperty("AWS_SECRET_ACCESS_KEY", "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")
  val conf: SparkConf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")
  var jssc = new JavaStreamingContext(conf, Durations.seconds(1))
  var broadcastvar = jssc.sparkContext.broadcast(new util.ArrayList[String])
  val s3Writer = new S3Writer
  val kafkaParams = Map[String, Object](
    "bootstrap.servers" -> "localhost:9092",
    "key.deserializer" -> classOf[StringDeserializer],
    "value.deserializer" -> classOf[StringDeserializer],
    "group.id" -> "use_a_separate_group_id_for_each_stream",
    "auto.offset.reset" -> "latest",
    "enable.auto.commit" -> (false: java.lang.Boolean)
  )

  val offsetRanges = Array[OffsetRange]( // topic, partition, inclusive starting offset, exclusive ending offset
    OffsetRange.create("topic_streams", 0, 0, 100), OffsetRange.create("topic_streams", 1, 0, 100))

  val topics = Array("topic_streams")

  def run: Unit = {
    val stream = KafkaUtils.createDirectStream[String, String](
      jssc,
      PreferConsistent,
      Subscribe[String, String](topics, kafkaParams)
    )

  }
}
