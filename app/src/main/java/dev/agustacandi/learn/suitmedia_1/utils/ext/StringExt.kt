package dev.agustacandi.learn.suitmedia_1.utils.ext

fun String.isPalindrome(): Boolean {
    val normalized = this.filter { it.isLetterOrDigit() }.lowercase()
    val reversed = normalized.reversed()
    return normalized == reversed
}