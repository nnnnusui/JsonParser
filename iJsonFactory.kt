package ga.nnnnusui.io.file.json
import ga.nnnnusui.io.file.json.enum.Value
import ga.nnnnusui.io.file.json.enum.Member
import ga.nnnnusui.io.file.json.JsonMember
import ga.nnnnusui.io.file.json.JsonPair
import ga.nnnnusui.io.file.json.JsonValue
import ga.nnnnusui.io.file.json.value.JsonString
import ga.nnnnusui.io.file.json.value.JsonNumber
import ga.nnnnusui.io.file.json.value.JsonObject
import ga.nnnnusui.io.file.json.value.JsonArray
import ga.nnnnusui.io.file.json.value.JsonTrue
import ga.nnnnusui.io.file.json.value.JsonFalse
import ga.nnnnusui.io.file.json.value.JsonNull

class iJsonFactory {
  companion object {
    fun create(type: Value): iJson = when(type) {
      Value.STRING -> JsonString()
      Value.NUMBER -> JsonNumber()
      Value.OBJECT -> JsonObject()
      Value.ARRAY  -> JsonArray()
      Value.TRUE   -> JsonTrue()
      Value.FALSE  -> JsonFalse()
      Value.NULL   -> JsonNull()
      //else -> Exception("不明なクラスを生成しようとした")
    }
    fun create(type: Member): iJson = when(type) {
      Member.MEMBER -> JsonMember()
      Member.PAIR   -> JsonPair()
      Member.VALUE  -> JsonValue()
    }
  }
}
