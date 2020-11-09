package br.com.dbsdev.financescontroller.finances_controller.infra.repository

import br.com.dbsdev.financescontroller.finances_controller.entities.Spent
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface SpentRepository :  MongoRepository<Spent, String>{
}