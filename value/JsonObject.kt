package ga.nnnnusui.io.file.json.value
import ga.nnnnusui.io.file.json.enum.Member
import ga.nnnnusui.io.file.json.iJsonFactory
import ga.nnnnusui.io.file.json.AbsJson

class JsonObject: AbsJson() {
  var value = iJsonFactory.create(Member.MEMBER)
  override fun parse(ch: Char) {
    if(value.complete) {
      when(ch) {
        '}'  -> complete = true
        else -> append(ch)
      }
    } else {
      append(ch)
    }
  }
  override fun append(ch: Char)
    { value.parse(ch) }
  override fun toString(): String
    = "${value.toString()}"
}
