package com.fashionstore.dao.interfaces;

import com.fashionstore.model.User;
import java.util.List;

public interface UserDAO {
    boolean register(User user);
    User login(String username, String password);
    User findByUsername(String username);
    User findByEmail(String email);
    User findById(int id);
    boolean updateProfile(User user);
    boolean updatePassword(int userId, String newPassword);
}