package com.example.mdorm.db
import android.database.sqlite.SQLiteDatabase
import com.example.mdorm.helper.QueryBuilder
import java.util.Objects


interface Database {
    fun openOrCreateDatabase(): SQLiteDatabase?

    fun insert(obj :Objects) : Long

    fun <T> store(collection: Collection<T>) : Int

    fun update(obj: Objects);

    fun <T> remove(cls : Class<T>)

    fun <T> removeAll(cls :Class<T>)



    fun close()
}
