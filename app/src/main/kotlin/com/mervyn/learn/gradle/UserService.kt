package com.mervyn.learn.gradle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * @author cs-mervyn
 * @date 2023/8/8 09:45
 * @version 1.0
 */
class UserService {
    var logger: Logger = LoggerFactory.getLogger(UserService::class.java)

    fun getUserName(): String {
        logger.info("Call get user name fun")
        return "cs-mervyn"
    }
}
