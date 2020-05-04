package com.matus;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.logging.Logger;

public class RecipientArticles {
     public static Logger log= Application.log;
    String page;
     static List<Article> articles=Application.article;
    public static List<Article> runner(String name) {
        List<Article> sub20;
        if (name.equals("1")) {
            sub20 = articles.subList(0, 20);
            log.info("selected one page");
        }
        else if(name.equals("2")){
            sub20 = articles.subList(20, 40);
            log.info("selected twoo page");
        }
        else if(name.equals("3")){
            sub20 = articles.subList(40, 60);
            log.info("selected three page");
        }
        else if (name.equals("4")){
            sub20 = articles.subList(60, 80);
            log.info("selected foor page");
        }
        else if (name.equals("5")){
            sub20 = articles.subList(80, 100);
            log.info("selected five page");
        }
        else{
            sub20 = articles.subList(0, 20);
            log.info("page s not selected");
        }
        return sub20;
    }
    public String getPage() {
        return page;
    }
    public void setPage(String page) {
        this.page = page;
        log.info(this.page);
    }
}
