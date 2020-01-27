package domain

import java.util


class Log(rawMessage: String) {
    var matchList: java.util.List[String] = util.Arrays.asList(rawMessage.split("\""))
  println("El tamaño de la lista es: " + matchList.size())
  try {
    var logchannel = matchList.get(1).replace("\\", "")
    var formatversion = matchList.get(3).replace("\\", "")
    var eventid = matchList.get(5).replace("\\", "")
    var timestamp = matchList.get(7).replace("\\", "")
    var companyid = matchList.get(9).replace("\\", "")
    var applianceid = matchList.get(11).replace("\\", "")
    var appliancemachinename = matchList.get(13).replace("\\", "")
    var realm = matchList.get(15).replace("\\", "")
    var userid = matchList.get(17).replace("\\", "")
    var hasheduserid = matchList.get(19).replace("\\", "")
    var useragent = matchList.get(21).replace("\\", "")
    var userhostaddress = matchList.get(23).replace("\\", "")
    var producttype = matchList.get(25).replace("\\", "")
    var receivetoken = matchList.get(27).replace("\\", "")
    var usejava = matchList.get(29).replace("\\", "")
    var allowedtoken = matchList.get(31).replace("\\", "")
    var authguimode = matchList.get(33).replace("\\", "")
    var authregmethod = matchList.get(35).replace("\\", "")
    var authregmethodinfo = matchList.get(37).replace("\\", "")
    var ispreauth = matchList.get(39).replace("\\", "")
    var preauthpage = matchList.get(41).replace("\\", "")
    var destinationsiteurl = matchList.get(43).replace("\\", "")
    var returnurl = matchList.get(45).replace("\\", "")
    var targeturl = matchList.get(47).replace("\\", "")
    var samlconsumersiteurl = matchList.get(49).replace("\\", "")
    var samlrelaystate = matchList.get(51).replace("\\", "")
    var samltargeturl = matchList.get(53).replace("\\", "")
    var succeed = matchList.get(55).replace("\\", "")
    var comment = matchList.get(57).replace("\\", "")
    var analyzeengineresult = matchList.get(59).replace("\\", "")
    var browsersession = matchList.get(61).replace("\\", "")
    var statemachineid = matchList.get(63).replace("\\", "")
    var requestid = matchList.get(65).replace("\\", "")
    var message = matchList.get(67).replace("\\", "")
  }
  catch {
    case x: Exception =>
      println("An error has occurred at filling the fields of the log")
  }

}
