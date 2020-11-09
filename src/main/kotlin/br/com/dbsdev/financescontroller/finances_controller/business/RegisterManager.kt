package br.com.dbsdev.financescontroller.finances_controller.business

import br.com.dbsdev.financescontroller.finances_controller.controllers.v1.dto.SpentDTO
import br.com.dbsdev.financescontroller.finances_controller.entities.Spent
import java.time.LocalDateTime

interface RegisterManager {
    fun includeRegister(spent: SpentDTO): String // return an id from new register
    fun updateRegister(id: String, spent: SpentDTO) // update an register
    fun removeRegister(id: String): SpentDTO // remove a registry and return them
    fun searchSpents(initialRegister: LocalDateTime, endRegister: LocalDateTime): List<SpentDTO> // list all registers in determinate datetime
    fun searchSpentById(id: String): SpentDTO // search an register with id code
}