package spark

import domain.Log
import utils.Utils
import org.apache.spark.api.java.function.VoidFunction
import org.apache.spark.broadcast.Broadcast
import utils.Utils
import java.io.Serializable
import java.util


class LogsFunction(var broadcastvar: Broadcast[java.util.List[String]]) extends VoidFunction[Log] with Serializable {
  @throws[Exception]
  override def call(log: Log): Unit = {
    val jsonLog = Utils.jsonLog(log)
    broadcastvar.value.add(jsonLog)
  }
}