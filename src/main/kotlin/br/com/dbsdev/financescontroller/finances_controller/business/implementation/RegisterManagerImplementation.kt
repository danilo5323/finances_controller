package br.com.dbsdev.financescontroller.finances_controller.business.implementation

import br.com.dbsdev.financescontroller.finances_controller.business.RegisterManager
import br.com.dbsdev.financescontroller.finances_controller.entities.Category
import br.com.dbsdev.financescontroller.finances_controller.entities.Spent
import br.com.dbsdev.financescontroller.finances_controller.entities.WayOfPayment
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDateTime

@Service
class RegisterManagerImplementation : RegisterManager{

    override fun updateRegister(id: Long, spent: Spent) {
        TODO("Not yet implemented")
    }

    override fun searchSpents(initialRegister: LocalDateTime, endRegister: LocalDateTime): List<Spent> {
        val item = Spent( BigDecimal(10), "", WayOfPayment.CREDIT_CARD, "", LocalDateTime.now(), Category(1, "") )
        val list = ArrayList<Spent>()
        list.add(item)
        return list
    }


    override fun includeRegister(spent: Spent?): Long {
        return 1
    }



    override fun searchSpentById(id: Long): Spent {
        return Spent( BigDecimal(10), "", WayOfPayment.CREDIT_CARD, "", LocalDateTime.now(), Category(1, "") )
    }

    override fun removeRegister(id: Long): Spent {
        return  Spent( BigDecimal(10), "", WayOfPayment.CREDIT_CARD, "", LocalDateTime.now(), Category(1, "") )
    }




}