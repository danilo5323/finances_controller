package br.com.dbsdev.financescontroller.finances_controller.business.implementation

import br.com.dbsdev.financescontroller.finances_controller.business.RegisterManager
import br.com.dbsdev.financescontroller.finances_controller.controllers.v1.dto.CategoryDTO
import br.com.dbsdev.financescontroller.finances_controller.controllers.v1.dto.SpentDTO
import br.com.dbsdev.financescontroller.finances_controller.entities.Category
import br.com.dbsdev.financescontroller.finances_controller.entities.Spent
import br.com.dbsdev.financescontroller.finances_controller.entities.WayOfPayment
import br.com.dbsdev.financescontroller.finances_controller.exception.ObjectCannotInsertException
import br.com.dbsdev.financescontroller.finances_controller.infra.repository.SpentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDateTime

@Service
class RegisterManagerImplementationService(
        @Autowired val spentRepository: SpentRepository
) : RegisterManager{

    override fun updateRegister(id: String, spent: SpentDTO) {
        //val entity = searchEntity(id)
        val entity = Spent.fromDTO(spent)
        entity.id = id;
        spentRepository.save(  entity )
    }

    override fun searchSpents(initialRegister: LocalDateTime, endRegister: LocalDateTime): List<SpentDTO> {
        val item = SpentDTO("", BigDecimal(10), "", WayOfPayment.CREDIT_CARD, "", LocalDateTime.now(), CategoryDTO(1, "") )
        val list = ArrayList<SpentDTO>()
        list.add(item)
        return list
    }


    override fun includeRegister(spent: SpentDTO): String {
        val spentEntity = Spent.fromDTO(spent)
        var responseObject: String =
                ""
        if(spent != null)
           responseObject= spentRepository.save(spentEntity).id!!;
        else{
            throw ObjectCannotInsertException("object cannot be inserted")
        }
        return responseObject
    }



    override fun searchSpentById(id: String): SpentDTO {
        val responseObject =  searchEntity(id)
        return  SpentDTO.fromEntity( responseObject)
    }

    override fun removeRegister(id: String): SpentDTO {
        val find = searchEntity(id)
        spentRepository.delete( find );
        return SpentDTO.fromEntity( find)
    }

    private fun searchEntity(id: String): Spent{
        val responseObject = spentRepository.findById(id)
        return responseObject.get()
    }




}