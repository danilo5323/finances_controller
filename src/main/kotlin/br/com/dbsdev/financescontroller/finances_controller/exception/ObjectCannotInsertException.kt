package br.com.dbsdev.financescontroller.finances_controller.exception

import java.lang.RuntimeException

class ObjectCannotInsertException(message: String?) : RuntimeException(message) {
}