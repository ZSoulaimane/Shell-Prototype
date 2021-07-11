package com.scala.oop.cmds

import com.scala.oop.files.{DirEntry, Directory}
import com.scala.oop.filesystem.State

class Mkdir(name : String) extends CreateEntry(name){
  override def CreateSpecificEntry(state: State): DirEntry =
    Directory.empty(state.wd.path,name)
}
