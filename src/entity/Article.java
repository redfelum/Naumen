/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;



import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "article")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Article.findById", query = "SELECT a FROM Article a WHERE a.id = :id"),
    @NamedQuery(name = "Article.findByShortName", query = "SELECT a FROM Article a WHERE a.shortName = :shortName"),
    @NamedQuery(name = "Article.findByFullName", query = "SELECT a FROM Article a WHERE a.fullName = :fullName"),
    @NamedQuery(name = "Article.findByBody", query = "SELECT a FROM Article a WHERE a.body = :body"),
    @NamedQuery(name = "Article.findByChapterId", query = "SELECT a FROM Article a WHERE a.chapter_id = :chapter_id"),
    @NamedQuery(name = "Article.search", query = "SELECT a FROM Article a WHERE a.body like :body")})
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "short_name")
    private String shortName;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "body")
    private String body;
    @JoinColumn(name = "chapter_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Chapter chapterId;
    @Column(name = "chapter_id", updatable=false, insertable=false)
    private Integer chapter_id;

    public Integer getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(Integer chapter_id) {
        this.chapter_id = chapter_id;
    }


    public Article() {
    }

    public Article(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Chapter getChapterId() {
        return chapterId;
    }

    public void setChapterId(Chapter chapterId) {
        this.chapterId = chapterId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ArticleHelpers[ id=" + id + " ]";
    }
    
}
