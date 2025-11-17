class PizzaPeter (prices: Map<String, Double>) : PizzaCity(prices) {
    override val cityName = "Санкт-Петербург"
    private val coffeePrice = 100.0

    override fun additionalServices(pizzaName: String) {
        println("Хотите кофе за $coffeePrice руб? (да/нет)")
        val coffee = readLine() ?: "нет"
        if (coffee.lowercase() == "да") {
            coffeeSalesCount++
            coffeeRevenue += coffeePrice
            totalRevenue += coffeePrice
            println("Кофе добавлен к заказу.")
        }
    }
}
