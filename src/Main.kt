fun main() {
    val MoscowPrices = mapOf("Маргарита" to 500.0, "Пепперони" to 600.0)
    val PeterPrices = mapOf("Маргарита" to 480.0, "Пепперони" to 580.0)
    val KislavodskPrices = mapOf("Маргарита" to 450.0, "Пепперони" to 550.0)
    val sauces = mapOf("Томатный" to 30.0, "Чесночный" to 40.0)

    println("Выберите город:\n1 - Москва\n2 - Санкт-Петербург\n3 - Кисловодск")
    when (readLine()) {
        "1" -> {
            val Moscow = PizzaMoscow(MoscowPrices)
            Moscow.selectPizza()
            Moscow.showStatistics()
        }
        "2" -> {
            val Peter = PizzaPeter(PeterPrices)
            Peter.selectPizza()
            Peter.showStatistics()
        }
        "3" -> {
            val kislavodsk = PizzaKislavodsk(KislavodskPrices, sauces)
            kislavodsk.selectPizza()
            kislavodsk.showStatistics()
        }
        else -> println("Неверный выбор города.")
    }
}