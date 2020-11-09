package br.com.dbsdev.financescontroller.finances_controller.entities

import java.math.BigDecimal
import java.time.LocalDateTime

data class Spent(
        val amountSpent: BigDecimal,
        val description: String,
        val wayOfPayment: WayOfPayment,
        val localBuilt: String,
        val dateOfSpent: LocalDateTime,
        val categorySpent: Category

) {

}