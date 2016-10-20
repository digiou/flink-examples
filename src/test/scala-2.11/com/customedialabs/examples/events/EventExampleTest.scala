package com.customedialabs.examples.events

import org.scalatest._
import com.customedialabs.examples.events.EventExample
/**
  * Created by digiou on 20/10/2016.
  */
class EventExampleTest extends FlatSpec with Matchers {
  "An EventExample" should "have working getter and setter for ID property" in {
    val eventExample = new EventExample
    eventExample.id_=(0)
    eventExample.id should be (0)
  }

  it should "have working getter and setter for value property" in {
    val eventExample = new EventExample
    eventExample.value_=(123)
    eventExample.value should be (123)
  }

  it should "have working getter and setter for text property" in {
    val eventExample = new EventExample
    eventExample.text_=("test")
    eventExample.text should be ("test")
  }

  it should "have working getter and setter for timestamp property" in {
    val eventExample = new EventExample
    eventExample.timestamp_=(Long.MinValue)
    eventExample.timestamp should be (Long.MinValue)
  }
}
