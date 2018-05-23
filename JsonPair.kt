package ga.nnnnusui.io.file.json
import ga.nnnnusui.io.file.json.enum.Member

class JsonPair: AbsJson() {
  private val key   = iJsonFactory.create(Member.VALUE)
  private val value = iJsonFactory.create(Member.VALUE)
  private var keyAppend = false

  override fun parse(ch: Char) {
    if(key.complete) {
      when(ch) {
        ':'  -> keyAppend = true
        else -> {}
      }
      if(keyAppend) {
        append(ch)
        if(value.complete)
          complete = true
      }
    } else {
      append(ch)
    }
  }
  override fun append(ch: Char) {
    if(key.complete)
      value.parse(ch)
    else
      key.parse(ch)
  }
  override fun toString()
    = "\n${key}: ${value}"
}
