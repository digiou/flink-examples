package xyz.digiou.examples.events

case class EventExample(id: Int, value: String, timestamp: Long) {

  def this() {
    this(0,"", 1L)
  }

  override def toString: String = {
    s"ID:$id\tValue:$value\tTimestamp:$timestamp"
  }
}
