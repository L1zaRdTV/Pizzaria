class PizzaMoscow(prices: Map<String, Double>) : PizzaCity(prices) {
    private val discount = 50.0
    override val cityName = "Москва"

    override fun sellPizza(pizzaName: String) {
        println("Показываете фото чека для скидки? (да/нет)")
        val photo = readLine() ?: "нет"
        var price = prices[pizzaName]!!
        if (photo.lowercase() == "да") {
            price -= discount
            checkPhotoCount++
            checkPhotoDiscountSum += discount
            println("Скидка $discount руб. применена.")
        }
        sales[pizzaName] = sales.getOrDefault(pizzaName, 0) + 1
        totalRevenue += price
        println("Продано $pizzaName за $price руб.")
    }

    override fun additionalServices(pizzaName: String) {
        println("Хотите кофе за 100 руб? (да/нет)")
        val coffee = readLine() ?: "нет"
        if (coffee.lowercase() == "да") {
            coffeeSalesCount++
            coffeeRevenue += 100.0
            totalRevenue += 100.0
            println("Кофе добавлен.")
        }
    }
}
