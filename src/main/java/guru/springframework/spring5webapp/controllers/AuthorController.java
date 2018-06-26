package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private AuthorsRepository authorsRepository;

    public AuthorController(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("autors", authorsRepository.findAll());
        return "authors";
    }

}
