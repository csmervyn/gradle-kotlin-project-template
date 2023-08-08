package com.mervyn.learn.gradle

import io.mockk.Runs
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.slot
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.slf4j.Logger
import kotlin.test.assertEquals

/**
 * @author cs-mervyn
 * @date 2023/8/8 12:23
 * @version 1.0
 */
@ExtendWith(MockKExtension::class)
class UserServiceTest {
    @MockK
    private lateinit var logger: Logger

    private lateinit var userService: UserService

    @BeforeEach
    fun setup() {
        userService = UserService()
        userService.logger = logger
    }

    @Test
    fun shouldLoggerWhenCallGetUserName() {
        // given
        val logMessageSlot = slot<String>()
        every { logger.info(capture(logMessageSlot)) } just Runs

        // when
        val userName = userService.getUserName()

        // then
        assertEquals(userName, "cs-mervyn")
        assertEquals(logMessageSlot.captured, "Call get user name fun")
    }
}
