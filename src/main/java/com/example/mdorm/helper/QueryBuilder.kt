package com.example.mdorm.helper


class QueryBuilder {
    var  query : String = "";
    var numberRunFunc = 0;
    val FROM = " FROM "
    val SELECT_TABLES = "SELECT * FROM sqlite_master WHERE type='table' ORDER BY name"
    val PRAGMA_TABLE_INFO = "PRAGMA table_info("
    val PARENTHESES_LEFT = "("
    val DROP_TABLE = "DROP TABLE "
    val IN = " IN "
    val SELECT_MAX = "SELECT MAX "
    val SELECT_ANY_FROM = "SELECT * FROM "
    val SELECT = "SELECT "
    val DELETE_FROM = "DELETE FROM "
    val ORDER_BY = " ORDER BY "
    val ASC = " ASC "
    val DESC = " DESC "
    val ON_CONFLICT = "ON CONFLICT "
    val PARENTHESES_RIGHT = ")"
    val NOT_NULL = "NOT NULL "
    val CREATE = "CREATE "
    val TEMP = "TEMP "
    val TABLE_IF_NOT_EXISTS = "TABLE IF NOT EXISTS "
    val PRIMARY_KEY_AUTOINCREMENT = "PRIMARY KEY AUTOINCREMENT "
    val PRIMARY_KEY = "PRIMARY KEY "
    val COMMA = ","
    val ASTERISK = "*"
    val BLANK = " "
    val COMMA_HOLDER = ",?"
    val DEFAULT = "DEFAULT "
    val UNIQUE = "UNIQUE "
    val WHERE = " WHERE "
    val CHECK = "CHECK "
    val COLLATE = "COLLATE "
    val LIMIT = " LIMIT "
    val EQUALS_HOLDER = "=?"
    val HOLDER = "?"
    val INSERT = "INSERT "
    val REPLACE = "REPLACE "
    val SET = " SET "
    val VALUES = "VALUES"
    val UPDATE = "UPDATE "
    val NOT = " NOT "
    val INTO = "INTO "
    val AND = " AND "
    val OR = " OR "
    val TWO_HOLDER = "(?,?)"

    fun dropTable(tableName : String) : String {
        query = "DROP_TABLE $tableName;"
        return query
    }

    fun createDB(dbName : String) :QueryBuilder{
        query = "CREATE DATABASE $dbName"
        return this
    }

    fun createTable(tableName: String , tables : Boolean) : QueryBuilder
    {
        query += "CREATE TABLE $tableName( "
        return this
    }

    fun createTable(tableName: String) : String
    {
        query = "CREATE TABLE $tableName"
        return query
    }
    fun addTable(valueName : String) :  QueryBuilder{
        numberRunFunc += 1
        if(numberRunFunc == 0){
            query += "($valueName "
            return this
        }
        query += "$valueName "
        return this
    }

    fun addTable(valueName : String , end: Boolean) :  QueryBuilder{

        query += " $valueName)"
        return this
    }

    fun integer() : QueryBuilder{
        query += " INTEGER,"
        return this
    }
    fun primaryInteger() : QueryBuilder{
        query += " INTEGER PRIMARY KEY,"
        return this
    }
    fun integer(end :Boolean) : QueryBuilder{
        query += " INTEGER)"
        return this
    }

    fun primary() : QueryBuilder{
        query += " PRIMARY"
        return this
    }
    fun primary(end: Boolean) : QueryBuilder{
        query += " PRIMARY)"
        return this
    }

    fun text() :  QueryBuilder{
        query += " TEXT"

        return this
    }

    fun updateColumn(tableName: String  ) :  QueryBuilder{
        query = "UPDATE $tableName WHERE "

        return this;
    }

    fun value(column: String , value : String) : QueryBuilder{
        query += "$column = $value ,"
        return this
    }

    fun orderBy(filed :String){
       query +=  " ORDER BY $filed";
    }

    fun count(tableName: String , field :String){
        query += "SELECT COUNT($field)FROM$field"
    }
    fun average(tableName: String , field :String){
        query += "SELECT AVG($field)FROM$field"
    }

    fun sum(tableName: String , field :String){
        query += "SELECT SUM($field)FROM$field"
    }
    fun <T> insert(tableName : String , cols : Array<String> , values : Array<T> ){
        query += "INSERT INTO $tableName"

        if(cols.isNotEmpty()){
            query += "("
            for (c in cols)
            {
                query += "$c ,"
            }
            query = removeSpecificCharAtString(query , query.length - 1 , ',')
            query += ")"
            query += " VALUES "
            query += "("
            for (v in values)
            {
                query += " $v ,"
            }
            query += ")"
            query = removeSpecificCharAtString(query , query.length - 2 , ',')
        }

    }

    private fun removeSpecificCharAtString(str: String, position: Int, chr: Char? = null) : String{
        val build: StringBuilder = StringBuilder(str)
        var charp =str[position];
        if(charp == chr){
            build.deleteCharAt(position )
        }
        return build.toString()

    }

    fun deleteCol(tableName : String ,colName : String , colValue :String   ){
        query += "DELETE FROM $tableName WHERE $colName = $colValue"
    }

    fun getQuery1() : String{
        val query = removeSpecificCharAtString(query , query.length - 1 , ',')

        return  "$query;"
    }



}