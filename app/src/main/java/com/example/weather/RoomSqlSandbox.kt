package com.example.weather

import androidx.room.*

@Entity(primaryKeys=["uid1", "uid2"])
data class User(
    var uid1: Int,
    var uid2: Int,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?,
    var address : Address
)

@Entity()
data class Address(
    var city: String?,
    @PrimaryKey var street: String?,
    var floor: Array<Int>
)

@Dao
interface UserDao {
    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM user")
    fun getAll(): List<User>
}

@Database(entities = [User::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
}