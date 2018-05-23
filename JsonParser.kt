package ga.nnnnusui.io.file.json
import ga.nnnnusui.io.file.json.enum.Member
import ga.nnnnusui.io.file.json.iJson
import ga.nnnnusui.io.file.json.iJsonFactory

import java.io.BufferedReader
import java.io.File
import java.nio.file.Paths


class JsonParser(
  val jsonFile: File
  ){
  val json: iJson = parse()

  fun parse(): iJson {
    val allText = jsonFile.bufferedReader().use(BufferedReader::readText)
    val json = iJsonFactory.create(Member.VALUE)
    allText.forEach {
      json.parse(it)
    }
    return json
  }
}


fun main(args: Array<String>) {
  val jsonPath = Paths.get("json_text_2")
  val json = JsonParser(jsonPath.toFile())
  println("$json ${json.json}")
}
