package org.example.SERVICES

import org.example.ENTITY.BookEntity

interface IBookService {
    fun getBookById(bookID: Int): BookEntity?
    fun getAllBooks(): List<BookEntity>?
    fun createBook(book: BookEntity): BookEntity?
    fun updateBook(book: BookEntity): BookEntity?
    fun deleteBook(bookID: Int): Boolean
}