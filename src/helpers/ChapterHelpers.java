package helpers;

import entity.Chapter;
import model.ChapterModel;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


public class ChapterHelpers {
    private static ChapterHelpers ourInstance = new ChapterHelpers();
    private ArrayList<String> menu = new ArrayList<String>();
    private ChapterModel chapterModel = new ChapterModel();

    public static ChapterHelpers getInstance() {
        return ourInstance;
    }

    private ChapterHelpers() {
        showTree();
    }

    public ArrayList<String> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<String> menu) {
        this.menu = menu;
    }


    public ArrayList<String> showTree() {
        menu = new ArrayList<String>();
        List<Chapter> res = chapterModel.getParentChapterList();
        getMenu().add("<ol>");
        for (int i = 0; i < res.size(); i++) {
            getMenu().add("<li><a href=/chapter/" + res.get(i).getId() + "> " + res.get(i).getShortName() + "</a>");
            showTreeRec(res.get(i).getId());
            getMenu().add("</li>");
        }
        getMenu().add("</ol>");


        return menu;
    }

    public ArrayList<String> showTreeRec(int ParentID) {
        List<Chapter> res = chapterModel.getChapterList(ParentID);
        if (res.size() > 0) {
            getMenu().add("<ol>");
            for (int i = 0; i < res.size(); i++) {
                int ID1 = res.get(i).getId();
                getMenu().add("<li><a href=/chapter/" + res.get(i).getId() + "> " + res.get(i).getShortName() + "</a>");
                showTreeRec(ID1);
                getMenu().add("</li>");
            }
            getMenu().add("</ol>");
        }
        return menu;
    }
}
