package org.example.DAO.sql

import org.example.DAO.IBookDAO
import org.example.DSF.DataBase
import org.example.ENTITY.BookEntity
import org.example.OUTPUT.IOutput
import java.sql.SQLException

class BookDAOSQL(private val console: IOutput): IBookDAO {
    private val connection = DataBase.getConnection()

    override fun createBook(book: BookEntity): BookEntity? {
        val sql = "INSERT INTO BOOKS VALUES (?, ?, ?, ?, ?, ?)"
        return try {
            connection.use { connection ->
                connection?.prepareStatement(sql).use { statement ->
                    statement?.setString(1, book.id.toString())
                    statement?.setString(2, book.titulo)
                    statement?.setString(3, book.autor)
                    statement?.setString(4, book.year.toString())
                    val rs = statement?.executeUpdate()
                    if (rs == 1){
                        connection?.close()
                        book
                    }
                    else{
                        connection?.close()
                        null
                    }
                }
            }
        }
        catch (e: SQLException){
            console.showMessage(e.message!!, true)
            return null
        }
    }

    override fun getAllBooks(): List<BookEntity>? {
        val sql = "SELECT * FROM BOOKS"
        return try {
            connection.use { connection ->
                connection?.prepareStatement(sql).use { stmt ->
                    val rs = stmt?.executeQuery()
                    val allBooks = mutableListOf<BookEntity>()
                    while (rs!!.next()) {
                        allBooks.add(
                            BookEntity(
                                id = (rs.getInt(1)),
                                titulo = rs.getString(2),
                                autor = rs.getString(3),
                                year = rs.getDate(4),
                            )
                        )
                    }
                    connection?.close()
                    allBooks
                }
            }
        }catch (e:SQLException){
            console.showMessage(e.message!!, true)
            connection?.close()
            null

        }catch (e:Exception){
            console.showMessage(e.message!!, true)
            connection?.close()
            null
        }
    }

    override fun getBookById(bookID: Int): BookEntity? {
        val sql = "SELECT * FROM BOOKS WHERE id = (?)"
        return try {
            connection.use { connection ->
                connection?.prepareStatement(sql).use { statement ->
                    statement?.setString(1, bookID.toString())
                    val rs = statement?.executeQuery()
                    if (rs!!.next()) {
                        BookEntity(
                            id = rs.getInt(1),
                            autor = rs.getString(2),
                            titulo = rs.getString(3),
                            year = rs.getDate(4)
                        )
                    } else {
                        console.showMessage("-- ERROR AL OBTENER EL PRODUCTO --", true)
                        null
                    }
                }
            }
        }catch (e:SQLException){
            console.showMessage(e.message!!, true)
            connection?.close()
            null

        } catch (e:Exception){
            console.showMessage(e.message!!, true)
            connection?.close()
            null
        }
    }

    override fun updateBook(book: BookEntity): BookEntity? {
        val sql = "UPDATE BOOKS SET title = (?), author = (?), releaseyear = (?) where id = (?)"
        return try {
            connection.use { connection ->
                connection?.prepareStatement(sql).use { statement ->
                    statement?.setString(1, book.titulo)
                    statement?.setString(2, book.autor)
                    statement?.setString(3, book.year.toString())
                    statement?.setString(4, book.id.toString())
                    statement?.executeUpdate()
                    connection?.close()
                    book
                }
            }
        } catch (e:SQLException){
            console.showMessage(e.message.toString(), true)
            connection?.close()
            null

        } catch (e:Exception){
            console.showMessage(e.message!!, true)
            connection?.close()
            null
        }
    }

    override fun deleteBook(bookID: Int): Boolean {
        val sql = "DELETE FROM BOOKS WHERE id = (?)"
        return try {
            connection.use {connection ->
                connection?.prepareStatement(sql).use { statement ->
                    statement?.setString(1, bookID.toString())
                    statement?.executeUpdate()
                    connection?.close()
                    true
                }
            }
        } catch (e:SQLException){
            console.showMessage(e.message!!, true)
            connection?.close()
            false

        }catch (e:Exception){
            console.showMessage(e.message!!, true)
            connection?.close()
            false
        }
    }
}