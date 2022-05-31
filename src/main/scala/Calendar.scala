case class Calendar(calendarTasks: List[Task]) {

  def addTask(task: Task): Calendar = {
    if (checkCalendar(task)) {
      println("Task added")
      val calendarTasksUptaded = calendarTasks :+ task
      Calendar(calendarTasksUptaded)
    } else this
  }

  def printTasks(): Unit = {
    this.calendarTasks.foreach(println)
  }

  def checkCalendar(taskToAdd: Task): Boolean = {
    if (calendarTasks.nonEmpty) {
      this.calendarTasks.forall(t => isAtSameTime(taskToAdd, t))
    } else true
  }

  def isAtSameTime(taskToAdd: Task, myTask: Task): Boolean = {

    val startGood = myTask.startDate.getTime <= taskToAdd.startDate.getTime && taskToAdd.startDate.getTime >= myTask.endDate.getTime
    val endGood = myTask.startDate.getTime <= taskToAdd.endDate.getTime && taskToAdd.endDate.getTime >= myTask.endDate.getTime
    startGood && endGood
  }

}
