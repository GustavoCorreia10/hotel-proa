package hotel.src.models

data class Room(val number: Int, var occupied: Boolean = false, val guests: MutableList<Guest> = mutableListOf()) {
}