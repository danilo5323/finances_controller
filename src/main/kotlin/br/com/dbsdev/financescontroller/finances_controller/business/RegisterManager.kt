package br.com.dbsdev.financescontroller.finances_controller.business

import br.com.dbsdev.financescontroller.finances_controller.entities.Spent
import java.time.LocalDateTime

interface RegisterManager {
    fun includeRegister(spent: Spent?): String // return an id from new register
    fun updateRegister(id: String, spent: Spent) // update an register
    fun removeRegister(id: String): Spent // remove a registry and return them
    fun searchSpents(initialRegister: LocalDateTime, endRegister: LocalDateTime): List<Spent> // list all registers in determinate datetime
    fun searchSpentById(id: String): Spent // search an register with id code
}