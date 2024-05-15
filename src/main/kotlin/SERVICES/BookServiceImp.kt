package org.example.SERVICES

import org.example.DAO.IBookDAO
import org.example.ENTITY.BookEntity

class BookServiceImp(private val bookDao:IBookDAO): IBookService {
    override fun getBookById(bookID: Int): BookEntity? {
        return bookDao.getBookById(bookID)
    }

    override fun getAllBooks(): List<BookEntity>? {
        return bookDao.getAllBooks()
    }

    override fun createBook(book: BookEntity): BookEntity? {
        return bookDao.createBook(book)
    }

    override fun updateBook(book: BookEntity): BookEntity? {
        return bookDao.updateBook(book)
    }

    override fun deleteBook(bookID: Int): Boolean {
        return bookDao.deleteBook(bookID)
    }
}