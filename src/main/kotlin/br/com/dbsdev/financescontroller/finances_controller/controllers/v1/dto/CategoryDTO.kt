package br.com.dbsdev.financescontroller.finances_controller.controllers.v1.dto

import br.com.dbsdev.financescontroller.finances_controller.entities.Category

data class CategoryDTO(
        var id: Long? = null,
        val description: String
) {

    companion object {
        fun fromEntity(categorySpent: Category) = CategoryDTO(
                categorySpent.id,
                categorySpent.description
        )
    }
}