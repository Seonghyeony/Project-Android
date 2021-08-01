package com.seonghyeon.android.bookreviewapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.seonghyeon.android.bookreviewapp.model.Review

@Dao
interface ReviewDao {
    @Query("SELECT * FROM review WHERE id == :id")
    fun getOneReview(id: Int): Review?

    @Insert(onConflict = OnConflictStrategy.REPLACE)    // 같은 것이 들어오면 대체.
    fun saveReview(review: Review)
}