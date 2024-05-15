package org.example.DAO

import org.example.DAO.file.BookDAOFile
import org.example.DAO.sql.BookDAOSQL
import org.example.DataSourceType
import org.example.OUTPUT.IOutput

class DaoFactory(private val console: IOutput, private val dataSourceType: DataSourceType) {
    fun getDAO(): IBookDAO{
        if (dataSourceType == DataSourceType.HIKARI){
            val bookDAOSQL = BookDAOSQL(console)
            return bookDAOSQL
        }
        else{
            val bookDAOFile = BookDAOFile()
            return bookDAOFile
        }
    }
}