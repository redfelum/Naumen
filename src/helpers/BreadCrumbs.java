package helpers;

import entity.Chapter;
import model.ChapterModel;

import java.util.ArrayList;

public class BreadCrumbs {
    private static BreadCrumbs ourInstance = new BreadCrumbs();
    private ArrayList<String> crumbs=new ArrayList<String>();
    private ChapterModel model=new ChapterModel();

    public static BreadCrumbs getInstance() {
        return ourInstance;
    }

    private BreadCrumbs() {
    }


    public ArrayList<String> getCrumbs() {
        return crumbs;
    }

    public void setCrumbs(ArrayList<String> crumbs) {
        this.crumbs = crumbs;
    }

    public void initCrumbs(int id){
        initCrumbsRec(id);
    }

    private void initCrumbsRec(int id){
        Chapter res = model.getChapter(id);
        if (res.getParentId()!=null) {
                int ID1 = res.getParentId();
                getCrumbs().add("-> <a href=/chapter/" + res.getId() + "> " + res.getShortName() + "</a> ");
                initCrumbsRec(ID1);
        }
        else{
            getCrumbs().add("<a href=/chapter/" + res.getId() + "> " + res.getShortName() + "</a> ");
        }

    }

    public void clear() {
        crumbs.clear();
    }
}
