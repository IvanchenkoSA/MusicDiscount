fun main() {
    val customer1 = Customer("Anatoliy")
    println(customer1)
    customer1.buy(1001)
    println(customer1)
    customer1.buy(1000)
    println(customer1)
    customer1.buy(11000)
    println(customer1)
    customer1.buy(12000)
    println(customer1)
}

data class Customer(val name: String, var totalSum: Int = 0, var countVisits: Int = 0) {
    fun buy(sum: Int) {
        val promotionOne = 100
        val promotionTwo = 5
        var promotionSum = when (totalSum) {
            in 0..1000 -> sum - sum
            in 1001..10000 -> promotionOne
            else -> (sum * promotionTwo) / 100
        }
        totalSum += (sum - promotionSum)
        println(
             """|
                |Сумма покупки $sum
                |Сумма скидки $promotionSum  
             """.trimMargin()
        )
        countVisits++
    }
}