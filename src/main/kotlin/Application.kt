package org.example

import org.example.ENTITY.BookEntity
import org.example.OUTPUT.IOutput
import org.example.SERVICES.IBookService
import java.sql.Date

class Application(private val console: IOutput, private val bookServiceImp: IBookService) {

    fun main(){
        console.showMessage("-- ALLOWED ACTIONS --", true)
        console.showMessage(" 1 - CREATE BOOK", true)
        console.showMessage(" 2 - GET ALL BOOKS", true)
        console.showMessage(" 3 - FILTER BY ID", true)
        console.showMessage(" 4 - UPDATE A BOOK'S DATA", true)
        console.showMessage(" 5 - DELETE BOOK", true)
        console.showMessage("-> ", false)
        val decission = console.getMessage()
        when (decission){
            "1" -> {
                val book = createBook()
                bookServiceImp.createBook(book)
            }
            "2" -> {}
            "3" -> {}
            "4" -> {}
            "5" -> {}
        }
    }

    private fun createBook(): BookEntity{
        console.showMessage("Enter the book's title", false)
        val title = console.getMessage()
        console.showMessage("Enter the book's author", false)
        val author = console.getMessage()
        console.showMessage("Enter the book's release date", false)
        val date = console.getMessage().toInt()
        return BookEntity(null, title, author, date)
    }


}