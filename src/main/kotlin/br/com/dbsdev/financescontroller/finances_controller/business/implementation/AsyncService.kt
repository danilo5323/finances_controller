package br.com.dbsdev.financescontroller.finances_controller.business.implementation

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class AsyncService {

    val LOG = Logger.getLogger(AsyncService::class.java.getName())
    @Async
    fun test(){
        Thread.sleep(5000)
        LOG.info("ahu ola la")
    }
}
