package br.com.dbsdev.financescontroller.finances_controller.controllers.v1.dto

import br.com.dbsdev.financescontroller.finances_controller.entities.Spent
import br.com.dbsdev.financescontroller.finances_controller.entities.WayOfPayment
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDateTime

@Document(collection = "Spents")
data class SpentDTO(
        @Id
        var id: String?,
        val amountSpent: BigDecimal,
        val description: String,
        val wayOfPayment: WayOfPayment,
        val localBuilt: String,
        val dateOfSpent: LocalDateTime,
        val categorySpent: CategoryDTO

        ) {
    companion object {
        fun fromEntity(spent: Spent) = SpentDTO(
                spent.id, spent.amountSpent, spent.description, spent.wayOfPayment
                , spent.localBuilt, spent.dateOfSpent, CategoryDTO.fromEntity(spent.categorySpent))
    }
}