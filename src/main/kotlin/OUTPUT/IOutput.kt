package org.example.OUTPUT

import org.example.DataSourceType

interface IOutput {

    fun showMessage(message:String, lineBreak: Boolean)

    fun getMessage(): String

    fun askForDataSourceType(): DataSourceType?
}