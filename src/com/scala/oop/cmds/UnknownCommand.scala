package com.scala.oop.cmds

import com.scala.oop.filesystem.State

class UnknownCommand extends Command {

  override  def apply(state : State):State =
    state.setMessage("Command not Found!")
}
