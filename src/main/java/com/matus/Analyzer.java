package com.matus;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public  class Analyzer {
     public Logger log=Application.log;
    public  int indexx;
    public void setIndexx(int indexx) {
        log.info("in Analyzer.index= "+this.indexx +"set variable indexx= "+ indexx);
        this.indexx = indexx;
    }
    public   List<String> getAtricles()throws IOException{
        boolean bool=false;
        int index = 1;
        List<String>zrp=new ArrayList<>();
        List<Integer>integers=new ArrayList<>();
        List<String> listURL = new ArrayList<>();
        while (!bool) {
            AtomicInteger i = new AtomicInteger();
            Document search = Jsoup.connect("http://sochi.hh.ru/search/resume?L_is_autosearch=false&area=237&clusters=true&exp_company_size=any&exp_industry=any&exp_period=last_year&logic=normal&no_magic=false&order_by=relevance&pos=position%2Cworkplace_position&text=%D0%9F%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B8%D1%81%D1%82&page=" + index).get();
            Elements rezultSearch = search.getElementsByAttributeValue("class", "resume-search-item__name");
            Elements soisk = search.getElementsByAttributeValue("class", "resume-search-item__content");
            soisk.forEach(so -> {
                so.getElementsByAttributeValue("class", "resume-search-item__compensation").forEach(fd -> {
                    if (fd.text().isEmpty()) {
                    } else {
                        zrp.add(fd.text());
                    }
                });
            });
            rezultSearch.forEach(y -> {
                listURL.add(y.attr("href"));
                i.getAndIncrement();
            });
            if (index!=indexx) {
                log.info("iteration= "+index);
                index++;
            }else{
                log.info("press wait for the analysis to finish var indexx= " + indexx);
                bool = true;
            }
            zrp.forEach(zp->{
                integers.add(Integer.valueOf(zp.replaceAll("[\\s. ]","").replaceAll("[a-zA-Zа-яА-Я]","")));
            });
        }
        log.info("method 'getArticles' returned object with size =  "+listURL.size());
        return listURL;
    }
    public  List<Article> getting(List<String> a) {
        //Вспомогательный лист для записи обязанностей предыдущих работ
        List<String> list = new ArrayList<>();
        //Вспомогательный лист для записи ключевых навыков
        List<String> exp = new ArrayList<>();
        //Содержит все строки по каждому СОИСКАТЕЛЬ-СТРОКА
        List<String> itog = new ArrayList<>();
        List<Article>articles=new ArrayList<>();
        a.forEach(elements->{
            Document doc = null;
            try {
                doc = Jsoup.connect("https://sochi.hh.ru"+elements).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            list.clear();
            exp.clear();
            Article soiskatel=new Article();
            //Непосредственное получение данных из документа  в локальные строковые переменные
            //И ДОБАВЛЕНИЕ ДАННЫЙ В ОБЪЕКТ Soiskatel
            String name=doc.getElementsByAttributeValue("data-qa","resume-personal-name").text();
            if(name.isEmpty()){name="name is not present";}
            soiskatel.setName(name);
            String phone=doc.getElementsByAttributeValue("data-qa", "resume-contact-preferred").text();
            if(phone.isEmpty()){phone="phone is not present";}
            soiskatel.setPhone(phone);
            String mail=doc.getElementsByAttributeValue("itemprop","email").text();
            if(mail.isEmpty()){phone="mail is not present";}
            soiskatel.setMail(mail);
            String copensation=doc.getElementsByAttributeValue("class", "resume-block__salary resume-block__title-text_salary").text();
            if(copensation.isEmpty()){copensation="no info of compensation";}
            soiskatel.setCompesation(copensation);
            String gender=doc.getElementsByAttributeValue("data-qa", "resume-personal-gender").text();
            soiskatel.setGender(gender);
            String age=doc.getElementsByAttributeValue("data-qa", "resume-personal-age").text();
            soiskatel.setAge(age);
            String sity=doc.getElementsByAttributeValue("data-qa", "resume-personal-address").text();
            soiskatel.setSity(sity);
            String birthday=doc.getElementsByAttributeValue("data-qa", "resume-personal-birthday").attr("content");
            soiskatel.setBirthDay(birthday);
            soiskatel.setUrl("https://sochi.hh.ru"+elements);
            //System.out.println("iam.getName().toUpperCase()" + "     " + iam.getGender() + "☢ :::☢ " + iam.getAge() + "☢ :::☢ " + iam.getSity() + "☢ :::☢ " + iam.getBirthDay());
            //Запись в лист с названием ИТОГ строки, содержащей данные о текущем элементе(соискателе)
            itog.add(name + "     ♀♂ " + gender + " ♀♂:::☢" + age + "☢:::☢" + sity + "☢:::₯ " + birthday+" ₯    ___\uD83D\uDCB0"+copensation+"\uD83D\uDCB0___");
            Elements h3 = doc.getElementsByAttributeValue("class", "bloko-tag bloko-tag_inline bloko-tag_countable");
            h3.forEach(element -> {
                Element e = element.child(0);
                String el = e.text();
                list.add(el);
            });
            soiskatel.setList(list);
            String listInOneString=String.join(" ",list);
            soiskatel.setListInOneString(listInOneString);
            Elements ele = doc.getElementsByAttributeValue("data-qa", "resume-block-experience-description");
            for (Element i : ele
            ) {
                exp.add(i.text());
            }
            soiskatel.setExp(exp);
            itog.add(" (-(-_(-_-)_-)-)  " + phone + "  email:  " + mail);
            exp.forEach(x -> {
                itog.add("!!!!!!!" + x.toUpperCase() + "!!!!!!!");
            });
            list.forEach(x -> {
                itog.add("(⌐■_■)" + x + "(⌐■_■)");
            });
            articles.add(soiskatel);
        });
        log.info("method  'greeting' returned object with size = "+ articles.size());
        return articles;
    }
}