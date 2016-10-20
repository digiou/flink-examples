package com.customedialabs.examples.events

/**
  * Created by digiou on 20/10/2016.
  */
class EventExample {
  private[this] var mId: Int = _
  private[this] var mValue: Int = _
  private[this] var mText: String = _
  private[this] var mTimestamp: Long = _

  // getters
  def id = mId
  def value = mValue
  def text = mText
  def timestamp = mTimestamp

  // setters
  def id_= (v: Int) = {mId = v}
  def value_= (v: Int) = {mValue = v}
  def text_= (s: String) = {mText = s}
  def timestamp_= (t: Long) = {mTimestamp = t}
}
