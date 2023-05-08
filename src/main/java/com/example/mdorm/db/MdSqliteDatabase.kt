package com.example.mdorm.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class MdSqliteDatabase(context: Context, dbName: String ,private var sqlCreateDB : String) :SQLiteOpenHelper(context, dbName, null, 1) , Database {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(sqlCreateDB)
    }


    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val db = this.writableDatabase
    }

    override fun openOrCreateDatabase(): SQLiteDatabase? {
        val db = this.writableDatabase
        db?.execSQL("")
        return db
    }

    override fun insert(objQuery : String) {
        val db = this.writableDatabase
        db.execSQL(objQuery)
        return
    }

    override fun store(objQuery: String)  {
        val db = this.writableDatabase
        db.execSQL(objQuery)
        return
    }

    override fun update(objQuery: String) {
        val db = this.writableDatabase
        db.execSQL(objQuery)
        return
    }

    override fun remove(objQuery: String) {
        val db = this.writableDatabase
        db.execSQL(objQuery)
        return
    }

    override fun removeAll(objQuery: String) {
        val db = this.writableDatabase
        db.execSQL(objQuery)
        return
    }
}