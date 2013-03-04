package controller;

import entity.Article;
import helpers.ChapterHelpers;
import helpers.ValidatorHelpers;
import model.ArticleModel;
import model.ChapterModel;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArticleController {
    private final ArticleModel articleModel = new ArticleModel();
    private final ValidatorHelpers validatorHelpers = new ValidatorHelpers();


    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    public ModelAndView getArticle(@PathVariable(value = "id") Integer id) {
        Article article = articleModel.getArticle(id);
        if (article != null)
            return new ModelAndView("/article/show", "article", article);
        else
            return new ModelAndView("/404");

    }

    @RequestMapping(value = "/article/new", method = RequestMethod.GET)
    public String newChapter(ModelMap model) {
        Article ArticleForm = new Article();
        model.put("article", ArticleForm);
        return "/article/new";
    }

    @RequestMapping(value = "/article/new", method = RequestMethod.POST)
    public String add(@ModelAttribute("article") Article article, BindingResult result) {
        validatorHelpers.validate(article, result);
        if (result.hasErrors())
            return "/article/new";
        else {
            ChapterModel model = new ChapterModel();
            article.setChapterId(model.getChapter(article.getChapter_id()));
            articleModel.createArticle(article);
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/article/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") Integer id) {
        articleModel.deleteArticle(id);
        return "redirect:/";
    }

}
