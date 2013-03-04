package controller;

import entity.Article;
import entity.Chapter;
import helpers.BreadCrumbs;
import model.ArticleModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchController {
    private  final ArticleModel articleModel =new ArticleModel();

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String text) {
       return new ModelAndView("/search","search", articleModel.searchArticle(text));
    }

}
