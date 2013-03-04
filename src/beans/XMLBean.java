package beans;

import entity.Article;
import entity.Chapter;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: openfler
 * Date: 01.03.13
 * Time: 10:17
 * To change this template use File | Settings | File Templates.
 */
public class XMLBean {
    private ArrayList<Chapter> chapterTree=new ArrayList<Chapter>();
    private ArrayList<Article> articleList= new ArrayList<Article>();

    public ArrayList<Chapter> getChapterTree() {
        return chapterTree;
    }

    public void setChapterTree(ArrayList<Chapter> chapterTree) {
        this.chapterTree = chapterTree;
    }

    public ArrayList<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(ArrayList<Article> articleList) {
        this.articleList = articleList;
    }
}
