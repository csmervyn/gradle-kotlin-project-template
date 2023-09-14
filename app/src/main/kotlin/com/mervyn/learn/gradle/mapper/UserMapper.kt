package com.mervyn.learn.gradle.mapper

import com.mervyn.learn.gradle.User
import com.mervyn.learn.gradle.dto.UserDto
import org.mapstruct.Mapper

/**
 * @author cs-mervyn
 * @date 2023/9/14 12:53
 * @version 1.0
 */
@Mapper
interface UserMapper {
    fun toUserDto(user: User): UserDto
}
