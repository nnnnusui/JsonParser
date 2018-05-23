package ga.nnnnusui.io.file.json
import ga.nnnnusui.io.file.json.enum.Member

class JsonMember: AbsJson() {
  val list = mutableListOf<iJson>()
  init { addList() }

  override fun parse(ch: Char) {
    if(list[list.size-1].complete) {
      when(ch) {
        ','  -> addList()
        else -> complete = true
      }
    } else {
      append(ch)
    }

  }
  override fun append(ch: Char) {
    if(list.size >= 0)
      list[list.size-1].parse(ch)
  }
  fun addList() {
    list.add(iJsonFactory.create(Member.PAIR))
  }
  override fun toString()
    = "${list.toString()}"
}
