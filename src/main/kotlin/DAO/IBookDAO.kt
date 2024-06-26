package org.example.DAO

import org.example.ENTITY.BookEntity

interface IBookDAO {
    fun getBookById(bookID: Int): BookEntity?
    fun getAllBooks(): List<BookEntity>?
    fun createBook(book: BookEntity): BookEntity?
    fun updateBook(book: BookEntity): BookEntity?
    fun deleteBook(bookID: Int): Boolean
}