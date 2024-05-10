package org.example.DAO

import org.example.ENTITY.BookEntity

interface IBookDAO {
    fun createProduct(book: BookEntity): BookEntity?
    fun getAllProducts(): List<BookEntity>?
    fun getProductById(id: Int): BookEntity?
    fun updateProducts(book: BookEntity): BookEntity?
    fun deleteProduct(id: Int): Boolean
}