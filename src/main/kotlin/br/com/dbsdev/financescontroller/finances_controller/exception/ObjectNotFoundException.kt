package br.com.dbsdev.financescontroller.finances_controller.exception

import java.lang.RuntimeException

class ObjectNotFoundException(message: String?) : RuntimeException(message) {
}