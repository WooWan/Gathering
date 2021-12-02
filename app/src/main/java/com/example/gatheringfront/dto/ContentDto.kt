package com.example.gatheringfront.dto

data class ContentDto(
    var title: String? = null,
    var description: String? = null,
    var skillList: List<String> = arrayListOf(),
    var uId: String? = null,
    var userId: String? = null,
    var timeStamp: Long? = null){

    data class Comment(
        var uId:String? = null,
        var userId: String? = null,
        var content: String?= null,
        var timeStamp: Long? = null
        )
}
