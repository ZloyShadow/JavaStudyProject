package com.restvote.votingsystem.web;

import com.restvote.votingsystem.AuthorizedUser;
import com.restvote.votingsystem.model.User;
import com.restvote.votingsystem.service.UserService;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {
    private final Logger log = LoggerFactory.getLogger(RootController.class);

    @Autowired
    private UserService service;

    @PostMapping("/users")
    public String changeUser(HttpServletRequest request) throws NotFoundException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = service.get(userId);
        AuthorizedUser.setId(userId);
        AuthorizedUser.setRole(user.getRole());
        log.info("setting for new user with id {} and role {}", userId, user.getRole());
        return "index.jsp";
    }
}
