package hotel.src.models

class HotelEvent(
    var name: String = "",
    var date: String = "",
    var hour: Int = 0,
    var duration: Int = 0,
    var waiters: Int = 0,
    var guests: Int = 0,
    var waiterValue: Double = 0.0,
    var buffetValue: Double = 0.0
)