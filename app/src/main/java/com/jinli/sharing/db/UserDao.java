package com.jinli.sharing.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Jin on 1/11/2019
 */
@Dao
public interface UserDao {

    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM User")
    List<User> getUsers();
}
