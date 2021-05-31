package cz.czechitas.java2webapps.ukol8.controller;

import cz.czechitas.java2webapps.ukol8.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public ModelAndView seznam(Pageable pageable){
        ModelAndView seznamPost = new ModelAndView("seznam");
        seznamPost.addObject("post", postService.list(pageable));
        return seznamPost;
    }

    @GetMapping("/post/{slug}")
        public ModelAndView post (@PathVariable String slug, Pageable pageable){
        ModelAndView detail = new ModelAndView("detail");
        detail.addObject("detail",postService.singlePost(slug,pageable).getContent().get(0));
        return detail;
    }



}
