import beans.XMLBean;
import controller.ChapterController;
import entity.Article;
import entity.Chapter;
import helpers.XMLHelpers;
import model.ArticleModel;
import model.ChapterModel;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class Main {


    public static void main(final String[] args) throws Exception {
        XMLBean bean = new XMLBean();
        XMLHelpers helper = new XMLHelpers();
        bean = helper.getConfiguration("InitDB.xml");
        ChapterModel cModel = new ChapterModel();
        for (int i = 0; i < bean.getChapterTree().size(); i++)
            cModel.createChapter(bean.getChapterTree().get(i));

    }


}
