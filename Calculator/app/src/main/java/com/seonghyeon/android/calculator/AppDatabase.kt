package com.seonghyeon.android.calculator

import androidx.room.Database
import androidx.room.RoomDatabase
import com.seonghyeon.android.calculator.dao.HistoryDao
import com.seonghyeon.android.calculator.model.History

@Database(entities = [History::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}