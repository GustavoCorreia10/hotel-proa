package hotel.src

import hotel.src.models.*
import kotlin.system.exitProcess

class Hotel(
    private val hotelName: String = "Correia Hotels",
    private var guestName: String? = null,
    private val rooms: List<Room> = listOf(
        Room(1),
        Room(2),
        Room(3),
        Room(4),
        Room(5),
        Room(6),
        Room(7),
        Room(8),
        Room(9),
        Room(10),
        Room(11),
        Room(12),
        Room(13),
        Room(14),
        Room(15),
        Room(16),
        Room(17),
        Room(18),
        Room(19),
        Room(20)
    ),
    private val registeredGuests: MutableList<Guest> = mutableListOf(),
    private val orangeAuditorium: Orange = Orange(),
    private val purpleAuditorium: Purple = Purple()
) {
    private val daily: Double = 150.0
    private var passReceived: String? = null

    fun start() {
        println("Bem vindo ao hotel $hotelName")
        println("Qual seu nome? ")
        guestName = readln()

        println("Insira a senha: ")
        passReceived = readln()

        if (verifyPass(passReceived)) {
            println(
                "Bem vindo ao Hotel $hotelName, $guestName. " +
                        "É um prazer ter você aqui!"
            )

            menu()
        }
    }

    private fun menu() {
        println(
            "Selecione sua opcão:  \n" +
                    "1 -> Selecionar um quarto  \n" +
                    "2 -> Menu de hospedes  \n" +
                    "3 -> Informacões sobre reabastecimento  \n" +
                    "4 -> Sair do hotel  \n"
        )
        val selected = readln().toInt()
        when (selected) {
            1 -> registerRoom()
            2 -> guestMenu()
            3 -> gasStationCheck()
            4 -> exitProcess(400)
            else -> mistake()

        }
    }

    private fun gasStationCheck() {
        println("Qual valor do litro do alcool no posto Wayne Oil? \n")
        val wayneAlcohol = readln().toInt() * 42

        println("Qual o valor do litro da gasolina no posto Wayne Oil? \n")
        val wayneGasoline = readln().toInt() * 42

        println("Qual o valor do litro do alcool no posto Stark Petrol? \n")
        val starkAlcohol = readln().toInt() * 42

        println("Qual o valor do litro da gasolina no posto Stark Petrol?")
        val starkGasoline = readln().toInt() * 42

        val cheapGasoline = getCheap(wayneGasoline,starkGasoline)

        val cheapAlcohol = getCheap(starkAlcohol, wayneAlcohol)

        if (cheapAlcohol < cheapGasoline * 0.7){
            when (cheapAlcohol) {
                starkAlcohol -> println("é mais barato abastecer com álcool no posto Stark")
                wayneAlcohol -> println("é mais barato abastecer com álcool no posto Wayne")
            }
        } else {
            when(cheapGasoline) {
                starkGasoline -> println("é mais barato abastecer com gasolina no posto Stark")
                wayneGasoline -> println("é mais barato abastecer com gasolina no posto Wayne")
            }
        }
    }

    private fun leave() {
        println("Retornando ao menu principal...")
        menu()
    }

    private fun guestMenu() {
        println(
            "Selecione sua opcão:  \n" +
                    "1 -> Cadastrar hospede  \n" +
                    "2 -> Pesquisar hospedes em especifico  \n" +
                    "3 -> Listar hospedes  \n" +
                    "4 -> Sair do menu de hospedes  \n"
        )

        val selected = readln().toInt()
        when (selected) {
            1 -> registerGuest()
            2 -> searchGuest()
            3 -> showAllGuests()
            4 -> leave()
            else -> mistake()
        }
    }

    private fun showAllGuests() {
        println("Os hospedes são: ")
        for (item in registeredGuests) {
            println(item.name)
        }
        guestMenu()
    }

    private fun searchGuest() {
        println("Insira o nome do hospede que deseja procurar: \n")
        val guestName = readln()
        var checker = false

        registeredGuests.forEach {
            if (it.name == guestName) {

                checker = true
            }
        }
        if (checker) {
            println("Hospede $guestName foi encontrado!")
        } else {
            println("Hospede $guestName não foi encontrado!")
        }

        guestMenu()
    }

    private fun registerGuest() {
        var gratuidades = 0
        var meias = 0
        var total = 0.0
        while (true) {
            if (registeredGuests.size >= 15) {
                println("Máximo de cadastros atingidos")
                break
            }


            println("Insira o nome do hòspede: ")
            val name = readln().lowercase()
            if (name == "pare") {
                break
            }
            println("Insira a idade do háspede, ou digite PARE")
            val age = readln().lowercase()
            if (age == "pare") {
                break
            }

            val newGuest = Guest(name, age.toInt())


            when {
                age.toInt() < 6 -> {
                    println("$name possui gratuidade")
                    gratuidades++
                }

                age.toInt() > 60 -> {
                    println("$name paga meia")
                    meias++
                    total += daily / 2
                }

                else -> total += daily
            }


            registeredGuests.add(newGuest)
        }
        println(
            "Gratuidades: $gratuidades \n" +
                    "Meias: $meias \n" +
                    "Total: $total \n"
        )
        guestMenu()
    }

    private fun registerRoom() {
        println("Informe a quantidade de dias que pretende se hospedar, sendo no máximo 30 dias: ")

        var days = readln().toInt()

        while (days > 30 || days <= 0) {
            println("Informe um valor válido: ")
            days = readln().toInt()
        }

        val total = days * daily

        println("Escolha um quarto | 1-20")
        var roomNumber = readln().toInt() - 1

        while (rooms[roomNumber].occupied) {
            println("Quarto já ocupado, escolha outro: ")
            roomNumber = readln().toInt() - 1
        }

        println("Você confirma a reserva? Y/N")
        val response = readln()
        if (response == "Y" || response == "y") {
            rooms[roomNumber].occupied = true
            println("Você reservou o quarto ${roomNumber + 1}, os $days dias custarão $total reais")
        } else {
            start()
        }
        menu()
    }

    fun bookAuditorium() {
        println("Insira a quantidade de convidados para a reserva: ")

        val visitants: Int = readln().toInt()

        when {
            visitants > 0 && visitants <= orangeAuditorium.chairs + orangeAuditorium.additional -> orangeAuditorium.reserve(
                visitants
            )

            visitants > 220 && visitants <= purpleAuditorium.chairs + purpleAuditorium.additional -> purpleAuditorium.reserve(
                visitants
            )
        }
    }
}
