package controller;

import entity.Article;
import entity.Chapter;
import helpers.BreadCrumbs;
import helpers.ChapterHelpers;
import helpers.ValidatorHelpers;
import model.ArticleModel;
import model.ChapterModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ChapterController {

    private ChapterModel chapterModel = new ChapterModel();
    private ArticleModel articleModel = new ArticleModel();
    private ValidatorHelpers validatorHelpers = new ValidatorHelpers();

    @RequestMapping(value = "/chapter/{id}", method = RequestMethod.GET)
    public ModelAndView getArticleOfChapter(@PathVariable(value = "id") Integer id, HttpSession session) {
        ChapterModel m = new ChapterModel();
        Chapter ch = m.getChapter(id);
        if (ch != null) {
            List<Article> article = articleModel.getArticleListOfChapter(id);
            BreadCrumbs.getInstance().initCrumbs(id);
            return new ModelAndView("/chapter/show", "chapter", article);
        } else {
            return new ModelAndView("/404");
        }
    }

    @RequestMapping(value = "/chapter/new", method = RequestMethod.GET)
    public String create(ModelMap model) {
        Chapter chapterForm = new Chapter();
        model.put("chapter", chapterForm);
        return "/chapter/new";
    }

    @RequestMapping(value = "/chapter/new", method = RequestMethod.POST)
    public String add(@ModelAttribute("chapter") Chapter chapter, BindingResult result) {
        validatorHelpers.validate(chapter, result);
        if (result.hasErrors()) {
            return "/chapter/new";
        } else {
            chapterModel.createChapter(chapter);
            ChapterHelpers.getInstance().showTree();
            return "redirect:/";
        }

    }

    @RequestMapping(value = "/chapter/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") Integer id) {
        chapterModel.deleteChapter(id);
        ChapterHelpers.getInstance().showTree();
        return "redirect:/";
    }


}
