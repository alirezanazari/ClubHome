package ir.alirezanazari.domain.entity

import java.util.*

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

data class UserProfile(
    val dsplayname: String? = null,
    val bio: String? = null,
    val twitter: String? = null,
    val instagram: String? = null,
    val numFollowers: Int = 0,
    val numFollowing: Int = 0,
    val followsMe: Boolean = false,
    val isBlockedByNetwork: Boolean = false,
    val timeCreated: Date? = null,
    val invitedByUserProfile: User? = null,
    val notificationType: Int = 0
) : User() {

    fun isFollowed() = notificationType == 2
}