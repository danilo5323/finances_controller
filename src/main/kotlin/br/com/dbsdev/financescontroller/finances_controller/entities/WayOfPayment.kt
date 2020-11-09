package br.com.dbsdev.financescontroller.finances_controller.entities

import io.swagger.annotations.ApiModel
@ApiModel
enum class WayOfPayment {
    CREDIT_CARD, DEBIT_CARD, IN_CASH
}