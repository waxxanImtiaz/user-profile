package com.user.profile.user.profile.controller;

import com.user.profile.user.profile.model.Account;
import com.user.profile.user.profile.service.AccountService;
import com.user.profile.user.profile.util.OnCreateAccountEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
@RestController
@RequestMapping("/management")
public class AccountController {
    @Value("${app.url}")
    private String appUrl;

    @Autowired
    private AccountService accountService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private ApplicationEventPublisher eventPublisher;


    @GetMapping("account")
    public String getRegistration(@ModelAttribute("account") Account account) {
        return "account";
    }

    @PostMapping(value = "account")
    public String addRegistration(@RequestBody Account account) {
        //encrypt password
        account.setPassword(encoder.encode(account.getPassword()));

        //create the account
        account = accountService.create(account);

        //fire off an event on creation
        eventPublisher.publishEvent(new OnCreateAccountEvent(account,appUrl));
        return "redirect:account";
    }
    @GetMapping("accountConfirm")
    public String confirmAccount(@RequestParam("token") String token) {
        accountService.confirmAccount(token);

        return "accountConfirmed";
    }

    @GetMapping("test")
    public String test(){
        return "This is test server";
    }
}
