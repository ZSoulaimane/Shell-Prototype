package com.scala.oop.cmds

import com.scala.oop.filesystem.State

trait Command {

  def apply(state: State): State
}

object Command {

  val MKDIR = "mkdir"
  val LS = "ls"
  val PWD = "pwd"
  val TOUCH = "touch"

  def incompleteCommand(name: String) : Command = new Command {
    override def apply(state: State): State = state.setMessage((name + ": incomplete Command!"))
  }

  def emptyCommand : Command = new Command {
    override def apply(state: State): State = state
  }

  def from(input: String) : Command = {
    val tokens: Array[String] = input.split(" ")

    if (input.isEmpty || tokens.isEmpty) emptyCommand
    else if (MKDIR.equals(tokens(0))) {
      if (tokens.length < 2) incompleteCommand(MKDIR)
      else new Mkdir(tokens(1))
    }else if (LS.equals(tokens(0))){
      new ls
    }else if (PWD.equals(tokens(0))){
      new Pwd
    }else if (TOUCH.equals(tokens(0))) {
      if (tokens.length < 2) incompleteCommand(MKDIR)
      else new Touch(tokens(1))
    }
    else new UnknownCommand
  }
}