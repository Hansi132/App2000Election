package com.app2000.electionbackend.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class RedirectController {

    @GetMapping()
    public RedirectView redirectHome(
            RedirectAttributes attributes) {
        return new RedirectView("/portalApp/index.html");
    }
}
