package com.user.profile.user.profile.repository;

import com.user.profile.user.profile.model.Password;
import com.user.profile.user.profile.model.ResetToken;

public interface PasswordRepository {
    void saveToken(ResetToken resetToken);

    ResetToken findByToken(String token);

    void update(Password password, String username);
}
