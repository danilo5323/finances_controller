package br.com.dbsdev.financescontroller.finances_controller.controllers.v1

import br.com.dbsdev.financescontroller.finances_controller.business.RegisterManager
import br.com.dbsdev.financescontroller.finances_controller.controllers.v1.dto.SpentDTO
import br.com.dbsdev.financescontroller.finances_controller.entities.Spent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import javax.annotation.Resource

@RestController
@RequestMapping("/register/spent/v1")
class RegisterController( @Resource val registerManager: RegisterManager) {

    @GetMapping("/{id}")
    fun searchSpentRegisterById(@PathVariable id: String): SpentDTO {
        return registerManager.searchSpentById(id)
    }

    @GetMapping("/{rangeInitial}/{rangeFinal}")
    fun searchSpentRegister(@PathVariable rangeInitial: LocalDateTime, @PathVariable rangeFinal: LocalDateTime): List<SpentDTO> {
        return registerManager.searchSpents(rangeInitial, rangeFinal)
    }

    @PutMapping
    fun updateRegister(@PathVariable id: String,
                       @RequestBody newSpent: SpentDTO) {
        registerManager.updateRegister(id, newSpent)
    }

    @PostMapping
    fun createSpentRegister(@RequestBody newSpent: SpentDTO): String {
        return registerManager.includeRegister(newSpent)
    }

    @DeleteMapping("/{id}")
    fun deleteSpentRegister(@PathVariable id: String): SpentDTO {
        return registerManager.removeRegister(id)
    }
}