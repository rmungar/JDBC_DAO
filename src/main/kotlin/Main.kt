package org.example

import org.example.DAO.DaoFactory
import org.example.OUTPUT.Console


fun main() {
    val console = Console()
    val dataSourceType = console.askForDataSourceType()
    if (dataSourceType != null){
        val daoFactory = DaoFactory(console, dataSourceType)
        val bookDao = daoFactory.getDAO()
    }

}