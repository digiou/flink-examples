package xyz.digiou.examples

import org.scalatest._

import scala.collection.mutable.Stack

/**
  * Created by digiou on 17/10/2016.
  */
class ExampleSpec extends FlatSpec with Matchers{

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.pop() should be (2)
    stack.pop() should be (1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[Int]
    a [NoSuchElementException] should be thrownBy {
      emptyStack.pop()
    }
  }
}
