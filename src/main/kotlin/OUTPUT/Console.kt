package org.example.OUTPUT

import org.example.DataSourceType

class Console: IOutput {

    override fun showMessage(message: String, lineBreak: Boolean) {
        if (lineBreak) println(message)
        else print(message)
    }

    override fun getMessage(): String {
        val message = readln()
        return message
    }

    override fun askForDataSourceType(): DataSourceType? {
        try {
            showMessage("Do you want to use a Database(1) or a File (2) -> ", false)
            val decission = getMessage()
            if (decission.toInt() == 1) return DataSourceType.HIKARI
            else return DataSourceType.FILE
        }
        catch (exception: NumberFormatException){
            showMessage("THAT IS NOT AN OPTION",true)
            return null
        }
    }
}