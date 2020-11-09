package br.com.dbsdev.financescontroller.finances_controller.controllers.v1.dto

import br.com.dbsdev.financescontroller.finances_controller.entities.Spent
import br.com.dbsdev.financescontroller.finances_controller.entities.WayOfPayment
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDateTime

@ApiModel
data class SpentDTO(
        var id: String?,
        val amountSpent: BigDecimal,
        val description: String,
        @ApiModelProperty(dataType = "String", allowableValues = "CREDIT_CARD, DEBIT_CARD, IN_CASH")
        val wayOfPayment: WayOfPayment,
        val localBuilt: String,
        val dateOfSpent: LocalDateTime?,
        val categorySpent: CategoryDTO
        ) {
    companion object {
        fun fromEntity(spent: Spent) = SpentDTO(
                spent.id, spent.amountSpent, spent.description, spent.wayOfPayment
                , spent.localBuilt, spent.dateOfSpent, CategoryDTO.fromEntity(spent.categorySpent))
    }
}