package com.mervyn.learn.gradle

import com.mervyn.learn.gradle.mapper.UserMapper
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test
import org.mapstruct.factory.Mappers

/**
 * @author cs-mervyn
 * @date 2023/9/14 12:55
 * @version 1.0
 */
class UserMapperTest {
    @Test
    fun `should convert user to userDto success`() {
        val mapper = Mappers.getMapper(UserMapper::class.java)
        val user = User("cs-mervyn", 18)

        val userDto = mapper.toUserDto(user)

        assertThat(userDto, notNullValue())
        assertThat(userDto.name, `is`("cs-mervyn"))
        assertThat(userDto.age, `is`(18))
    }
}
