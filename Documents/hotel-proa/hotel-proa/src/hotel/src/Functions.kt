package hotel.src

fun verifyPass(passReceived: String?): Boolean {

    return when (passReceived){
        "2678" -> true
        else -> false
    }
}

fun getCheap(a: Int, b: Int): Int {
    return if (a < b){
        a
    } else {
        b
    }
}

fun mistake() {
    println("Erro desconhecido")
}