package ir.alirezanazari.domain.entity

import java.util.*

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

data class Event(
    val channel: String? = null,
    val isExpired: Boolean = false,
    val timeStart: Date? = null,
    val description: String? = null,
    val name: String? = null,
    val eventId: Int = 0,
    val isMemberOnly: Boolean = false,
    val hosts: List<UserProfile?>? = null,
    val clubIsMember: Boolean = false,
    val clubIsFollower: Boolean = false
)
