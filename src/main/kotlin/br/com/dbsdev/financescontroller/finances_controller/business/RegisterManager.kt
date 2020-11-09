package br.com.dbsdev.financescontroller.finances_controller.business

import br.com.dbsdev.financescontroller.finances_controller.entities.Spent
import java.time.LocalDateTime

interface RegisterManager {
    fun includeRegister(spent: Spent?): Long // return an id from new register
    fun updateRegister(id: Long, spent: Spent) // update an register
    fun removeRegister(id: Long): Spent // remove a registry and return them
    fun searchSpents(initialRegister: LocalDateTime, endRegister: LocalDateTime): List<Spent> // list all registers in determinate datetime
    fun searchSpentById(id: Long): Spent // search an register with id code
}