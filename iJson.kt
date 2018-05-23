package ga.nnnnusui.io.file.json

interface iJson {
  var complete: Boolean
  fun parse(ch: Char)
  fun append(ch: Char)
}
