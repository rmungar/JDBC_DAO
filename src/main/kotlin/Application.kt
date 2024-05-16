package org.example

import org.example.ENTITY.BookEntity
import org.example.OUTPUT.IOutput
import org.example.SERVICES.IBookService

class Application(private val console: IOutput, private val bookServiceImp: IBookService) {

    fun main(){
        while (true) {
            console.showMessage("", true)
            console.showMessage("-- ALLOWED ACTIONS --", true)
            console.showMessage(" 1 - CREATE BOOK", true)
            console.showMessage(" 2 - GET ALL BOOKS", true)
            console.showMessage(" 3 - FILTER BY ID", true)
            console.showMessage(" 4 - UPDATE A BOOK'S DATA", true)
            console.showMessage(" 5 - DELETE BOOK", true)
            console.showMessage(" 0 - EXIT", true)
            console.showMessage("-> ", false)
            val decission = console.getMessage()
            when (decission) {
                "1" -> {
                    val book = instantiateBook()
                    if (book != null) bookServiceImp.createBook(book)
                    else console.showMessage("UNABLE TO CREATE THE BOOK", true)
                }

                "2" -> {
                    val books = bookServiceImp.getAllBooks()
                    if (!books.isNullOrEmpty()) {
                        books.forEach {
                            console.showMessage(it.toString(), true)
                        }
                    } else {
                        console.showMessage("NO BOOKS FOUND", true)
                    }
                }

                "3" -> {
                    console.showMessage("ENTER A BOOK'S ID: ", false)
                    val id = console.getMessage()
                    try {
                        val book = bookServiceImp.getBookById(id.toInt())
                        console.showMessage(book.toString(), true)
                    } catch (exception: NumberFormatException) {
                        console.showMessage(exception.message!!, true)
                    }

                }

                "4" -> {
                    val book = instantiateBook()
                    if (book != null){
                        bookServiceImp.updateBook(book)
                    }
                }

                "5" -> {
                    console.showMessage("ENTER A BOOK'S ID: ", false)
                    val id = console.getMessage()
                    try {
                        bookServiceImp.deleteBook(id.toInt())
                    } catch (exception: NumberFormatException) {
                        console.showMessage(exception.message!!, true)
                    }
                }

                "0" -> break
            }
        }
    }

    private fun instantiateBook(): BookEntity?{
        try {
            console.showMessage("Enter the book's title ", false)
            val title = console.getMessage()
            console.showMessage("Enter the book's author ", false)
            val author = console.getMessage()
            console.showMessage("Enter the book's release date ", false)
            val date = console.getMessage().toInt()
            return BookEntity(null, title, author, date)
        } catch (exception:Exception){
            console.showMessage(exception.message!!, true)
            return null
        }
    }


}