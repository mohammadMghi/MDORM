package com.example.mdorm.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.*

class SqliteDatabase(context : Context , dbName : String , ) :SQLiteOpenHelper(context, dbName, null, 1) , Database {
    override fun onCreate(db: SQLiteDatabase?) {

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    override fun openOrCreateDatabase(): SQLiteDatabase? {
        TODO("Not yet implemented")
    }

    override fun insert(obj: Objects): Long {
        TODO("Not yet implemented")
    }

    override fun <T> store(collection: Collection<T>): Int {
        TODO("Not yet implemented")
    }

    override fun update(obj: Objects) {
        TODO("Not yet implemented")
    }

    override fun <T> remove(cls: Class<T>) {
        TODO("Not yet implemented")
    }

    override fun <T> removeAll(cls: Class<T>) {
        TODO("Not yet implemented")
    }
}