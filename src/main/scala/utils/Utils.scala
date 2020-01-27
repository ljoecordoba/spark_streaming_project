package utils

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import domain.Log


object Utils {

  def jsonLog(log: Log): String = {
    val mapper = new ObjectMapper
    mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
    var json = ""
    try {
      json = mapper.writeValueAsString(log);
    }
    catch {
      case x: JsonProcessingException =>
        println(x.printStackTrace())
    }
    return json
  }

}
