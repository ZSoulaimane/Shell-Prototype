package com.scala.oop.cmds
import com.scala.oop.files.{DirEntry, File}
import com.scala.oop.filesystem.State

class Touch(name : String) extends CreateEntry(name){

  override def CreateSpecificEntry(state: State): DirEntry =
    File.empty(state.wd.path, name)
}
