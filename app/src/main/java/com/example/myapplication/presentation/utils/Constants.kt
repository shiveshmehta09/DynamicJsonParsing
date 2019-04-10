package com.example.myapplication.presentation.utils

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations


/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */
const val GET_PHOTOS = "get_photos"
const val BASE_URL = "https://affiliate-api.flipkart.net/affiliate/"

/** Uses `Transformations.map` on a LiveData */
fun <X, Y> LiveData<X>.map(body: (X) -> Y): LiveData<Y> {
    return Transformations.map(this, body)
}

/** Uses `Transformations.switchMap` on a LiveData */
fun <X, Y> LiveData<X>.switchMap(body: (X) -> LiveData<Y>): LiveData<Y> {
    return Transformations.switchMap(this, body)
}