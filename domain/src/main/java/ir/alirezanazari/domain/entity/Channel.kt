package ir.alirezanazari.domain.entity

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

data class Channel(
    val creatorUserProfileId: Int = 0,
    val channelId: Int = 0,
    val channel: String? = null,
    val topic: String? = null,
    val isPrivate: Boolean = false,
    val isSocialMode: Boolean = false,
    val url: String? = null,
    val numOther: Int = 0,
    val hasBlockedSpeakers: Boolean = false,
    val isExploreChannel: Boolean = false,
    val numSpeakers: Int = 0,
    val numAll: Int = 0,
    val users: List<ChannelUser> = listOf(),
    val token: String? = null,
    val isHandraiseEnabled: Boolean = false,
    val pubnubToken: String? = null,
    val pubnubHeartbeatValue: Int = 0,
    val pubnubHeartbeatInterval: Int = 0
)
