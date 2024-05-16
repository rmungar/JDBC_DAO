package org.example

import org.example.DAO.DaoFactory
import org.example.OUTPUT.Console
import org.example.SERVICES.BookServiceImp


fun main() {
    val console = Console()
    val dataSourceType = console.askForDataSourceType()
    if (dataSourceType != null){
        val daoFactory = DaoFactory(console, dataSourceType)
        val bookDao = daoFactory.getDAO()
        val bookServiceImp = BookServiceImp(bookDao)
        val application = Application(console, bookServiceImp)
        application.main()
    }
    else{
        console.showMessage("INVALID DATASOURCE", true)
    }

}