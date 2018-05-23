package ga.nnnnusui.io.file.json.value
import ga.nnnnusui.io.file.json.enum.Member
import ga.nnnnusui.io.file.json.iJson
import ga.nnnnusui.io.file.json.iJsonFactory
import ga.nnnnusui.io.file.json.AbsJson


class JsonArray: AbsJson() {
  val list = mutableListOf<iJson>()
  init { addList() }

  override fun parse(ch: Char) {
    if(list[list.size-1].complete) {
      when(ch) {
        ']'  -> complete = true
        else -> addList()
      }
    } else {
      append(ch)
    }
  }
  override fun append(ch: Char) {
    list[list.size-1].parse(ch)
  }
  fun addList() {
    list.add(iJsonFactory.create(Member.VALUE))
  }
  override fun toString()
    = "${list.toString()}"
}
