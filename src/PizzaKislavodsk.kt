class PizzaKislavodsk (
    prices: Map<String, Double>,
    private val saucesWithPrices: Map<String, Double>
) : PizzaCity(prices) {
    override val cityName = "Кисловодск"

    init {
        saucePrices.putAll(saucesWithPrices)
    }

    override fun additionalServices(pizzaName: String) {
        println("Хотите добавить соус? Доступны: ${saucesWithPrices.keys.joinToString()}. Введите название соуса или 'нет':")
        val sauceChoice = readLine() ?: "нет"
        if (sauceChoice.lowercase() != "нет" && saucesWithPrices.containsKey(sauceChoice)) {
            sauceSales[sauceChoice] = sauceSales.getOrDefault(sauceChoice, 0) + 1
            val price = saucesWithPrices[sauceChoice]!!
            totalRevenue += price
            println("Добавлен соус $sauceChoice за $price руб.")
        } else if (sauceChoice.lowercase() != "нет") {
            println("Такого соуса нет.")
        }
        println("Хотите кофе за 120 руб? (да/нет)")
        val coffee = readLine() ?: "нет"
        if (coffee.lowercase() == "да") {
            coffeeSalesCount++
            coffeeRevenue += 120.0
            totalRevenue += 120.0
            println("Кофе добавлен.")
        }
        println("Показываете фото чека для скидки? (да/нет)")
        val photo = readLine() ?: "нет"
        if (photo.lowercase() == "да") {
            val discount = 40.0
            totalRevenue -= discount
            checkPhotoCount++
            checkPhotoDiscountSum += discount
            println("Скидка $discount руб. применена.")
        }
    }
}
