package br.com.dbsdev.financescontroller.finances_controller.entities

import br.com.dbsdev.financescontroller.finances_controller.controllers.v1.dto.SpentDTO
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDateTime

@Document(collection = "Spents")
data class Spent(
        @Id
        var id: String?,
        val amountSpent: BigDecimal,
        val description: String,
        val wayOfPayment: WayOfPayment,
        val localBuilt: String,
        val dateOfSpent: LocalDateTime,
        val categorySpent: Category,
        var deleted: LocalDateTime?

) {
        companion object {
                fun fromDTO(spentDto: SpentDTO) = Spent(
                        spentDto.id,
                        spentDto.amountSpent,
                        spentDto.description,
                        spentDto.wayOfPayment,
                        spentDto.localBuilt,
                        LocalDateTime.now(),
                        Category.fromDTO(spentDto.categorySpent),
                        null
                )
        }
}