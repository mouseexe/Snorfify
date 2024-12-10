package gay.spiders.snorfify.util

fun Int.toPosition(): String = when (this.toString().last()) {
    '1' -> this.toString() + "st"
    '2' -> this.toString() + "nd"
    '3' -> this.toString() + "rd"
    else -> this.toString() + "th"
}