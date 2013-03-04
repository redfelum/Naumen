package controller;

import entity.Article;
import entity.Chapter;
import helpers.BreadCrumbs;
import helpers.ValidatorHelpers;
import model.ArticleModel;
import model.ChapterModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class WelcomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getArticleOfChapter() {
        ChapterModel m = new ChapterModel();
        return new ModelAndView("/index","chapter",m.getChapterList());
    }
}
