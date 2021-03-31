package ir.alirezanazari.domain.entity

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

data class ChannelUser(
    val isSpeaker: Boolean = false,
    val isModerator: Boolean = false,
    val isFollowedBySpeaker: Boolean = false,
    val isInvitedAsSpeaker: Boolean = false,
    val isNew: Boolean = false,
    val timeJoinedAsSpeaker: String? = null,
    val firstName: String? = null
) : User()