package hotel.src.models

import kotlin.math.ceil

abstract class Auditorium(
    val chairs: Int,
    val additional: Int,
    private val name: String,
    protected val event: HotelEvent = HotelEvent(),
    private val week: List<String> = listOf(
        "segunda",
        "terca",
        "quarta",
        "quinta",
        "sexta",
        "sabado",
        "domingo"
    ),
) {


    abstract fun reserve(visitants: Int)

    protected fun schedule() {
        println("Agora vamos ver a agenda do evento \n")

        println("Qual o dia do seu evento?")
        val date = readln().lowercase()
        event.date = date


        if (week.indexOf(date) <= 3) {
            println("Qual a hora do seu evento?")
            val hour = readln().toInt()
            event.hour = hour

            if (hour in 7..23) {
                println("Qual o nome da sua empresa?")
                val businessName = readln()
                event.name = businessName

                println("Auditorio reservado para a empresa $businessName. $date as ${hour}hs")

            } else {
                println("Auditorio indisponivel")
            }

        }
    }

    protected fun waiters(visitants: Int) {
        val waiters = ceil((visitants / 12).toDouble()).toInt()
        event.waiters = waiters
        println("Serão necessarios $waiters garcons \n")

        println("Qual a duracão do evento em horas? \n")
        val hours = readln().toInt()
        event.duration = hours

        val waitersPrice = waiters * hours * 10.50
        event.waiterValue = waitersPrice

        println("O Custo dos garcons sera $waitersPrice")
    }

    protected fun buffet(visitants: Int) {
        val coffee = visitants * 0.2
        val water = visitants * 0.5
        val savory = visitants * 7

        val total = coffee + water + savory
        event.buffetValue = total

        println(
            "o evento precisara de $coffee litros de cafe para $visitants convidados \n" +
                    "$water litros de agua para $visitants convidados \n" +
                    "$savory salgados para $visitants convidados \n"
        )

        println(
            "Os precos serão: \n" +
                    "Cafe: ${ceil(coffee * 0.80)} reais \n" +
                    "Agua: ${ceil(water * 0.40)} reais \n" +
                    "Salgados: ${ceil(savory * 0.34)} reais \n" +
                    "Total: $total \n"
        )

    }

    protected fun confirm() {
        println("Evento no auditorio $name")
        println("Nome da empresa: ${event.name}")
        println("Data: ${event.date}. ${event.hour} as ${event.hour + event.duration}")
        println("Duracao: ${event.duration}H")
        println("Quantidade de garcons: ${event.waiters}")
        println("Custo dos garcons: ${event.waiterValue}")
        println("Custo do buffet: ${event.buffetValue} \n")

        println("Valor total do evento: ${event.buffetValue + event.waiters} \n")

        println("Gostaria de efetuar a reserva completa? S/N")
        val response = readln().lowercase()

        when (response) {
            "s" -> println("Reserva efetuada")
            "n" -> println("Reserva não efetuada")
        }
    }
}