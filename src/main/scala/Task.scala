case class Task(start: String, end: String) {

  import java.text.SimpleDateFormat

  val format = new SimpleDateFormat("yy/MM/dd HH:mm:ss")
  val startDate = format.parse(start)
  val endDate = format.parse(end)

}