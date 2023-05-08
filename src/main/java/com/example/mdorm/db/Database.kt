package com.example.mdorm.db
import android.database.sqlite.SQLiteDatabase
import com.example.mdorm.helper.QueryBuilder
import java.util.Objects


interface Database {
    fun openOrCreateDatabase(): SQLiteDatabase?

    fun insert(objQuery : String)

    fun store(objQuery : String)

    fun update(objQuery : String);

    fun  remove(objQuery : String)

    fun removeAll(objQuery : String)



    fun close()
}
