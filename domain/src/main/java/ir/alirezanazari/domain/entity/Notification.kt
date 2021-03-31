package ir.alirezanazari.domain.entity

import java.util.*

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

data class Notification(
    val notificationId: Int = 0,
    val inUnread: Boolean = false,
    val userProfile: User? = null,
    val eventId: Int = 0,
    val type: Int = 0,
    val timeCreated: Date? = null,
    val message: String? = null
)
