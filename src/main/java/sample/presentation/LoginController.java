package sample.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
public class LoginController {
    @GetMapping
    String ログイン画面() {
        return "login";
    }
}
