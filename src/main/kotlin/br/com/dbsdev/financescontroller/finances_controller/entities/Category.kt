package br.com.dbsdev.financescontroller.finances_controller.entities

import br.com.dbsdev.financescontroller.finances_controller.controllers.v1.dto.CategoryDTO

data class Category(
        var id: Long? = null,
        val description: String
){

    companion object{
        fun fromDTO(categoryDTO: CategoryDTO) = Category(categoryDTO.id, categoryDTO.description)
    }
}