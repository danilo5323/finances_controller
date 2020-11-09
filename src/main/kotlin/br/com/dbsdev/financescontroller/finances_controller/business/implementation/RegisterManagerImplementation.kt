package br.com.dbsdev.financescontroller.finances_controller.business.implementation

import br.com.dbsdev.financescontroller.finances_controller.business.RegisterManager
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
class RegisterManagerImplementation(
        @Autowired val spentRepository: SpentRepository
) : RegisterManager{

    override fun updateRegister(id: String, spent: Spent) {
        TODO("Not yet implemented")
    }

    override fun searchSpents(initialRegister: LocalDateTime, endRegister: LocalDateTime): List<Spent> {
        val item = Spent("", BigDecimal(10), "", WayOfPayment.CREDIT_CARD, "", LocalDateTime.now(), Category(1, "") )
        val list = ArrayList<Spent>()
        list.add(item)
        return list
    }


    override fun includeRegister(spent: Spent?): String {
        var responseObject: String =
                ""
        if(spent != null)
           responseObject= spentRepository.save(spent).id!!;
        else{
            throw ObjectCannotInsertException("object cannot be inserted")
        }
        return responseObject
    }



    override fun searchSpentById(id: String): Spent {
        val responseObject = spentRepository.findById(id)
        return responseObject.get()
    }

    override fun removeRegister(id: String): Spent {
        val find = searchSpentById(id)
        spentRepository.delete(find);
        return find
    }




}