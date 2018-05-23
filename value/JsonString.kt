package ga.nnnnusui.io.file.json.value
import ga.nnnnusui.io.file.json.iJsonFactory
import ga.nnnnusui.io.file.json.AbsJson

class JsonString: AbsJson() {
  val value  = StringBuilder()
  var escape = false
  override fun parse(ch: Char) {
    if(escape) {
      append(ch)
      escape = false
    } else {
      when(ch) {
        '\\' -> escape = true
        '"'  -> complete = true
        else -> append(ch)
      }
    }
  }
  override fun append(ch: Char)
    { value.append(ch) }

  override fun toString(): String
    = value.toString()
}
