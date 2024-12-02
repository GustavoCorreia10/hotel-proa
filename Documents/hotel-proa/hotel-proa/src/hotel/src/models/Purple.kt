package hotel.src.models

class Purple() : Auditorium(350,  0, "Colorado") {

    override fun reserve(visitants: Int) {
        println("O auditorio colorado foi reservado, nesse auditorio não são necessarias cadeiras adicionais")
        schedule()
        waiters(visitants)
        buffet(visitants)
        confirm()
    }


}