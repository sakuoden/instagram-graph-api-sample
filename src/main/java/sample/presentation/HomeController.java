package sample.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sample.application.InstagramService;
import sample.infrastructure.api.response.media.MediasResponse;

@Controller
@RequestMapping("/")
public class HomeController {
    InstagramService instagramService;

    @GetMapping
    String ホーム画面(Model model) {
        MediasResponse medias = instagramService.medias();
        model.addAttribute("mediaList", medias.data());

        return "home";
    }

    HomeController(InstagramService instagramService) {
        this.instagramService = instagramService;
    }
}
