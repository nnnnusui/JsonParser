package ga.nnnnusui.io.file.json.enum

enum class Member(val type: String, val parser: Array<Char>) {
  MEMBER("member", arrayOf(',')),
  PAIR(  "pair",   arrayOf(':')),
  VALUE( "value",  arrayOf()),
}
