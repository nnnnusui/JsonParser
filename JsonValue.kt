package ga.nnnnusui.io.file.json
import ga.nnnnusui.io.file.json.enum.Value
import ga.nnnnusui.io.file.json.AbsJson
import ga.nnnnusui.io.file.json.iJsonFactory

class JsonValue: AbsJson() {
  var valueType: Value? = null
  var value: iJson? = null
  var line = 1

  override fun parse(ch: Char) {
    when {
      ch=='\n' -> line++
      ch==' '  -> {}
      value != null -> {
        append(ch)
        if(value?.complete ?: false) {
          complete = true
        }
      }
      else -> {
        value = when(ch) {
          '"' -> iJsonFactory.create(Value.STRING)
          '1' -> iJsonFactory.create(Value.NUMBER)
          '{' -> iJsonFactory.create(Value.OBJECT)
          '[' -> iJsonFactory.create(Value.ARRAY)
          't' -> iJsonFactory.create(Value.TRUE)
          'f' -> iJsonFactory.create(Value.FALSE)
          'n' -> iJsonFactory.create(Value.NULL)
          else-> null
        }
      }
    }
  }
  override fun append(ch: Char) {
    try {
      value!!.parse(ch)
    } catch(e: Exception) {
      println("error: catchNull _ line: $line")
    }
  }
  override fun toString()
    = value.toString()
}
