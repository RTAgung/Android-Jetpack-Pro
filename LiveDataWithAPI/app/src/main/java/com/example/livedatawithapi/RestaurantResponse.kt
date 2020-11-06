package com.example.livedatawithapi

import com.google.gson.annotations.SerializedName

data class RestaurantResponse(
    val restaurant: Restaurant,
    val error: Boolean,
    val message: String
)

data class CustomerReviewsItem(
    val date: String,
    val review: String,
    val name: String
)

data class Restaurant(
    val customerReviews: List<CustomerReviewsItem>,
    val pictureId: String,
    val name: String,
    val rating: Double,
    val description: String,
    val id: String
)

data class PostReviewResponse(
    @field:SerializedName("customerReviews")
    val consumerReviews: List<CustomerReviewsItem>,
    @field:SerializedName("error")
    val error: Boolean,
    @field:SerializedName("message")
    val message: String
)