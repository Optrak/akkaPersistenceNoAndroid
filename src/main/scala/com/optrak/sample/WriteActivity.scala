package com.optrak.sample

import akka.persistence.{Persistent, Processor}
import akka.actor.{Props, ActorSystem}

object ExampleProcessor {
  def props(): Props = Props(new ExampleProcessor())
}

class ExampleProcessor extends Processor {
  var received: List[String] = Nil // state

  def receive = {
    case "print" => println(s"received ${received.reverse}")
    case "boom" => throw new Exception("boom")
    case Persistent("boom", _) => throw new Exception("boom")
    case Persistent(payload: String, _) => received = payload :: received
  }

  override def preRestart(reason: Throwable, message: Option[Any]) {
    message match {
      case Some(p: Persistent) if !recoveryRunning => deleteMessage(p.sequenceNr) // mark failing message as deleted
      case _ => // ignore
    }
    super.preRestart(reason, message)
  }
}

/**
 * Created by oscarvarto on 4/23/14.
 */
object WriteActivity extends App {

  val system = ActorSystem("example")
  val processor = system.actorOf(ExampleProcessor.props(), "DummyProcessor")

  processor ! Persistent("a")
  processor ! "print"
  processor ! "boom" // restart and recovery
  processor ! "print"
  processor ! Persistent("b")
  processor ! "print"
  processor ! Persistent("boom") // restart, recovery and deletion of message from journal
  processor ! "print"
  processor ! Persistent("c")
  processor ! "print"

  Thread.sleep(1000)
  system.shutdown()
}
