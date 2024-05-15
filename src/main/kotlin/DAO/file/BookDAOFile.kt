package org.example.DAO.file

import org.example.DAO.IBookDAO
import org.example.ENTITY.BookEntity

class BookDAOFile(): IBookDAO {
    override fun getBookById(bookID: Int): BookEntity? {
        TODO("Not yet implemented")
    }

    override fun getAllBooks(): List<BookEntity>? {
        TODO("Not yet implemented")
    }

    override fun createBook(book: BookEntity): BookEntity? {
        TODO("Not yet implemented")
    }

    override fun updateBook(book: BookEntity): BookEntity? {
        TODO("Not yet implemented")
    }

    override fun deleteBook(bookID: Int): Boolean {
        TODO("Not yet implemented")
    }
}