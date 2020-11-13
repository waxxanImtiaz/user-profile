package com.user.profile.user.profile.service;

import com.user.profile.user.profile.model.Password;
import com.user.profile.user.profile.model.ResetToken;
import com.user.profile.user.profile.repository.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService {

    @Autowired
    private PasswordRepository passwordRepository;

    @Override
    public void createResetToken(Password password, String token) {
        ResetToken resetToken = new ResetToken();
        resetToken.setToken(token);
        resetToken.setEmail(password.getEmail());
        resetToken.setUsername(password.getUsername());

        passwordRepository.saveToken(resetToken);
    }

    @Override
    public boolean confirmResetToken(ResetToken token) {
        return false;
    }

    @Override
    public void update(Password password, String username) {
        passwordRepository.update(password, username);
    }
}
