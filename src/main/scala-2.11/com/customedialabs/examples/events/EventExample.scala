package com.customedialabs.examples.events

/**
  * Created by digiou on 20/10/2016.
  */
case class EventExample(id: Int, value: String, timestamp: Long) {

  def this() {
    this(0,"", 1L)
  }

  override def toString: String = {
    s"ID:$id\tValue:$value\tTimestamp:$timestamp"
  }
}
