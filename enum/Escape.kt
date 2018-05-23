package ga.nnnnusui.io.file.json.enum

enum class Escape(val value: Char, val key: Char) {
    SINGLE_QUOTATION('\'', '\''),
    DOUBLE_QUOTATION('\"', '\"'),
    BACK_SLASH('\\', '\\'),
    NEW_LINE('\n', 'n'),
    RETURN('\r', 'r'),
    TAB('\t', 't'),
    BACK_SPACE('\b', 'b'),
}
