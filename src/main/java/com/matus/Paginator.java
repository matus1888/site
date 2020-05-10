package com.matus;

import java.util.ArrayList;
import java.util.List;

public  class Paginator{
    public static int quantityCards=Application.article.size();
    public static int quantityCardsOnPage=20;
    public static List<Article> globalProps= Application.article;
    public static List<Integer> globalPages = getListPages();

    public static List<Integer> getListPages(){
        List<Integer> pages = new ArrayList<>();
        for (int i = 0; i < (quantityCards)/20+1; i++) {
            pages.add(i);
        }
        pages.forEach(g-> System.out.print("["+g+"]"));
        return pages;
    }
    public static List<Article> getProperties(int currentPage){

        List<Article> currentProps= null;
        System.out.println("globalPages.size*20= "+globalPages.size()*20);
        if(currentPage<=0){
            System.out.println("this is realisation <= 0 ");
            currentProps=globalProps.subList(1,quantityCardsOnPage);
        }
        else if(currentPage*20>globalProps.size()) {
            System.out.println("this is realisation end page");
            currentProps=globalProps.subList(currentPage*quantityCardsOnPage-quantityCardsOnPage,globalProps.size());
        }
        else{
            System.out.println("-------currentPage= "+currentPage+"------------");
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
            System.out.println("<-------current paginator num1--------->");
            pagesMassive.forEach(x -> System.out.print("[" + x + "]"));
            System.out.println(" size= "+pagesMassive.size());
        }
        else if(currentPage>2&&currentPage<globalPages.size()-2){
            pagesMassive=globalPages.subList(currentPage-2,currentPage+3);
            System.out.println("<-------current paginator num2--------->");
            pagesMassive.forEach(x -> System.out.print("[" + x + "]"));
            System.out.println(pagesMassive.size());
        }
        else if(currentPage>=(globalPages.size()-2)){
            pagesMassive=globalPages.subList(globalPages.size()-5,globalPages.size());
            System.out.println("<-------current paginator num3--------->");
            pagesMassive.forEach(x -> System.out.print("[" + x + "]"));
            System.out.println(pagesMassive.size());
        }
        return pagesMassive;
    }
}
