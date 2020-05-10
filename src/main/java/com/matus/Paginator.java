package com.matus;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public  class Paginator{
    public static int quantityCards=Application.article.size();
    public static int quantityCardsOnPage=20;
    public static List<Article> globalProps= Application.article;
    public static List<Integer> globalPages;
    public static Logger log= Application.log;

    public static void getListPages(){
        List<Integer> pages = new ArrayList<>();
        for (int i = 0; i < (quantityCards)/20+1; i++) {
            pages.add(i);
        }
        log.info("create list 'pages' mit all pages, size= "+pages.size());
        globalPages=pages;
    }
    public static List<Article> getProperties(int currentPage){
        List<Article> currentProps= null;
        if(currentPage<=0){
            log.info("this is realisation 'getProperties' mit 'currentPage'<= 0 ");
            currentProps=globalProps.subList(1,quantityCardsOnPage);
        }
        else if(currentPage*20>globalProps.size()) {
            currentPage=globalPages.size();
            log.info("this is realisation 'getProperties' mit 'currentPage'> limit");
            currentProps=globalProps.subList(currentPage*quantityCardsOnPage-quantityCardsOnPage,globalProps.size());
        }
        else{
            log.info("this is basic realisation method 'getProperties'");
            currentProps=globalProps.subList(currentPage*quantityCardsOnPage-quantityCardsOnPage,
                    currentPage*quantityCardsOnPage-1);
        }
        return currentProps;
    }
    //Paginator size= 5!!!!
    public static List<Integer> getAListOfPages(int currentPage){
        List<Integer> pagesMassive=null;
        if(currentPage<=2){
            pagesMassive=globalPages.subList(0, 5);
            log.info("is a realization 'getAListPages' mit current pages<=2");
        }
        else if(currentPage>2&&currentPage<globalPages.size()-2){
            pagesMassive=globalPages.subList(currentPage-2,currentPage+3);
            log.info("is a basic realization 'getAListPages'");
        }
        else if(currentPage>=(globalPages.size()-2)){
            pagesMassive=globalPages.subList(globalPages.size()-5,globalPages.size());
            log.info("is a basic realization 'getAListPages' mit 'currentPage' >=limit");
        }
        return pagesMassive;
    }
}
