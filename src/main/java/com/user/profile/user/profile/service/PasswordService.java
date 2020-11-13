package com.user.profile.user.profile.service;


import com.user.profile.user.profile.model.Password;
import com.user.profile.user.profile.model.ResetToken;

public interface PasswordService {

    void createResetToken(Password password, String token);

    boolean confirmResetToken(ResetToken token);

    void update(Password password, String username);

}
