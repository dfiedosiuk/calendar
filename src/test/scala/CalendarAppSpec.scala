import org.scalatest._
import flatspec._
import matchers._

class CalendarAppSpec extends AnyFlatSpec with should.Matchers {

  behavior of "Calendar"

  val dateStart = "11/03/14 09:00:00"
  val dateStop = "11/03/14 09:10:00"

  val firstTask: Task = Task(dateStart, dateStop)

  val start2 = "11/03/14 09:25:00"
  val end2 = "11/03/14 09:30:00"

  val secondTask: Task = Task(start2, end2)

  val start3 = "11/03/14 09:05:00"
  val end3 = "11/03/14 09:15:00"

  val thirdTask: Task = Task(start3, end3)


  it should "allow to add tasks to empty calendar" in {
    val myCalendar1: Calendar = Calendar(List.empty[Task])

    myCalendar1.checkCalendar(firstTask) shouldBe true

  }

  it should "allow to add tasks if it is possible" in {
    val myCalendar2: Calendar = Calendar(List.empty[Task])

    myCalendar2.addTask(firstTask).checkCalendar(secondTask) shouldBe true

  }

  it should "not allow to add tasks if it is not possible" in {
    val myCalendar3: Calendar = Calendar(List.empty[Task])

    myCalendar3.addTask(firstTask).checkCalendar(thirdTask) shouldBe false

  }

}
