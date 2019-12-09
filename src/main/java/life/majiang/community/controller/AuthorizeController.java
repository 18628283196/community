package life.majiang.community.controller;

import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.GithubUser;
import life.majiang.community.model.User;
import life.majiang.community.provider.GithubProvider;
import life.majiang.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
    @Autowired
    private UserService userService;

    @Value(value = "${github.client.id}")
    private String clientId;
    @Value(value = "${github.client.secret}")
    private String secret;
    @Value(value = "${github.redirect.uri}")
    private String redirectUri;


    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request, HttpServletResponse response) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setClient_secret(secret);

        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser getUser = githubProvider.getUser(accessToken);

        if (getUser != null) {
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(getUser.getName());
            user.setAccountId(String.valueOf(getUser.getId()));
            user.setAvatarUrl(getUser.getAvatarUrl());
            //这里就相当于存入Session中
            userService.createOrUpdate(user);
            response.addCookie(new Cookie("token", token));
            //登录成功，写入cookie和Session
            /*request.getSession().setAttribute("user", getUser);*/
            return "redirect:/";
        } else {
            //登录失败，重新登陆
            return "redirect:/";
        }
    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return "redirect:/";
    }
}
