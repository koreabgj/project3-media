package com.example.teamproject_11.data.model

import com.google.gson.annotations.SerializedName

//유튜브 API 데이터 전송 형태
data class YouTubeResponse(
    @SerializedName("kind") val kind: String?,
    @SerializedName("etag") val etag: String?,
    @SerializedName("nextPageToken") val nextPageToken: String?,
    @SerializedName("prevPageToken") val prevPageToken: String?,
    @SerializedName("pageInfo") val pageInfo: Page?,
    @SerializedName("items") val items: List<YouTubeVideo>?,
)

//유튜브 전송 데이터 속성 중 PageInfo 오브젝트 클래스
data class Page(
    val totalResults: Int?,
    val resultsPerPage: Int,
)

//유튜브 전송 데이터 솓성 중 items에 해당하는 오브젝트 클래스

data class YouTubeVideo(
    val kind: String?,
    val etag: String?,
    val id: String,
    val snippet: Snippet?
)

//items의 속성 중 snippet에 해당하는 오브젝트 클래스, snippet은 해당 item의 업로드 시간 및 제목, 영상 설명 등의 속성을 가지고 있음
// items의 속성 중 snippet에 해당하는 오브젝트 클래스
data class Snippet(
    @SerializedName("publishedAt") val publishedAt: String?,
    @SerializedName("channelId") val channelId: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("thumbnails") val thumbnails: Thumbnails?,
    @SerializedName("tags") val tags: List<String?>?,
    @SerializedName("categoryId") val categoryId: String?
)

//snippet의 속성 중 썸네일에 해당하는 오브젝트 클래스, 해당 클래스는 Key라는 오브젝트 속성을 가지고 Key에 이미지 url 및 너비 길이 정보가 있음

data class Thumbnails(
    @SerializedName("default")
    val default: Key,
    @SerializedName("medium")
    val medium: Key,
    @SerializedName("high")
    val high: Key
)

data class Key(
    val url: String?,
    val width: Int?,
    val height: Int?,
)


// 검색 items 오브젝트 클래스

data class YouTubeSearchResponse(
    @SerializedName("kind") val kind: String?,
    @SerializedName("etag") val etag: String?,
    @SerializedName("items") val items: List<YouTubeVideoItem>?,
    @SerializedName("nextPageToken") val nextPageToken: String?,
)

data class YouTubeVideoItem(
    @SerializedName("id") val id: YouTubeVideoSearchId?,
    @SerializedName("snippet") val snippet: SearchSnippet?
)

data class YouTubeVideoSearchId(
    @SerializedName("kind") val kind: String?,
    @SerializedName("videoId") val videoId: String?,
    @SerializedName("channelId") val channelId: String?,
    @SerializedName("playlistId") val playlistId: String?
)

data class SearchSnippet(
    @SerializedName("publishedAt") val publishedAt: String?,
    @SerializedName("channelId") val channelId: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("thumbnails") val thumbnails: SearchThumbnails?,
    @SerializedName("channelTitle") val channelTitle: String?,
    @SerializedName("liveBroadcastContent") val liveBroadcastContent: String?
)

data class SearchThumbnails(
    @SerializedName("default") val default: Thumbnail?,
    @SerializedName("medium") val medium: Thumbnail?,
    @SerializedName("high") val high: Thumbnail?
)

data class Thumbnail(
    @SerializedName("url") val url: String?,
    @SerializedName("width") val width: Int?,
    @SerializedName("height") val height: Int?
)