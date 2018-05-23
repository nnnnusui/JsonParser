package ga.nnnnusui.io.file.json

abstract class AbsJson(): iJson {
  override var complete = false
  override fun parse(ch: Char) {}
  override fun append(ch: Char) {}
  /* override fun toString(): String
    = "${value}" */
}
