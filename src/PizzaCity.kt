abstract class PizzaCity(protected val prices: Map<String, Double>) { //abstractзначитчтонельзясоздатьобъектэтогоклассанапрямуюВrонструкторпередаётсяpricesкарт«название пиццы → цена.
protected — переменная доступна внутри самого класса и его наследников (подклассов).
    protected val sales = mutableMapOf<String, Int>() //salesхранитстатистикупродаж
    protected var totalRevenue = 0.0 //totalRevenueобщаявыручкавгород

    protected var checkPhotoCount = 0 //checkPhotoCountскольколюдейпоказаличек.checkPhotoDiscountSumсколькорублейушлонаскидки.
    protected var checkPhotoDiscountSum = 0.0

    protected var coffeeSalesCount = 0 //скокпроданноинакакуюсумму
    protected var coffeeRevenue = 0.0

    protected val sauceSales = mutableMapOf<String, Int>() //статиценнасоуса
    protected val saucePrices = mutableMapOf<String, Double>()

    abstract val cityName: String
    //abstract.значит.что.нельзя.создать.объект.этого.класса.напрямую. protectedпеременнаядоступнавнутрисамогоклассаиегоподклассов.

    open fun sellPizza(pizzaName: String) {
        val price = prices[pizzaName] ?: run {
            println("Пиццы $pizzaName нет.")
            return
        } //цикл для ошибки
        sales[pizzaName] = sales.getOrDefault(pizzaName, 0) + 1
        totalRevenue += price
        println("Продано $pizzaName за $price руб.")
    } //инфо о продаже увеличеваем счетчик продаж

    fun showStatistics() {
        println("Статистика $cityName:")
        sales.forEach { (pizza, count) ->
            val amount = count * prices[pizza]!! //увереность ключ сущ
            println("$pizza: продано $count, сумма $amount руб.")
        } //счет выручки и тд
        if (checkPhotoCount > 0) {
            println("Чеки показано: $checkPhotoCount (скидки суммарно $checkPhotoDiscountSum руб.)")
            val percentShowCheck = (checkPhotoCount.toDouble() / sales.values.sum()) * 100
            println("Процент показывающих чек: %.2f%%".format(percentShowCheck))
        } //чеки
        if (coffeeSalesCount > 0) {
            println("Продано кофе: $coffeeSalesCount, выручка: $coffeeRevenue руб.")
            val percentCoffeeBuy = (coffeeSalesCount.toDouble() / sales.values.sum()) * 100
            println("Процент покупающих кофе: %.2f%%".format(percentCoffeeBuy))
        } //кофе
        if (sauceSales.isNotEmpty()) {
            println("Продано соусов:")
            sauceSales.forEach { (sauce, count) ->
                val amount = count * saucePrices.getOrDefault(sauce, 0.0)
                println("$sauce: $count шт., сумма $amount руб.")
            }
        } //соусы
        println("Общая выручка с учётом скидок и доп. услуг: $totalRevenue руб.")
    }

    abstract fun additionalServices(pizzaName: String) //город сам должен определить

    fun selectPizza() {
        while (true) {
            println("Выберите пиццу (${prices.keys.joinToString()}) или 'выход':")
            val choice = readLine() ?: ""
            if (choice.lowercase() == "выход") break
            if (!prices.containsKey(choice)) {
                println("Такой пиццы нет.")
                continue
            }
            sellPizza(choice)
            additionalServices(choice)
        }
    }
}
