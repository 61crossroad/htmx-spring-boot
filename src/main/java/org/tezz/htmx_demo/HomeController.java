package org.tezz.htmx_demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    static List<String> searchResults = List.of("one", "two", "three", "four", "five");

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/search")
    public String getMethodName(String q, Model model) {
        var filtered = searchResults
            .stream()
            .filter(s -> s.startsWith(q.toLowerCase()))
            .toList();

        model.addAttribute("results", filtered);
        return "search :: results";
    }
    

    @PostMapping("/clicked")
    public String postMethodName(Model model) {
        model.addAttribute("now", LocalDateTime.now().toString());
        return "clicked :: result";
    }
}
