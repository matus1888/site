package com.matus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
public class Application {
    public  static final Logger log= Logger.getLogger(Analyzer.class.getName());
    static List<Article> article;
    public static void main(String[] args)  {
        SpringApplication.run(Application.class, args);
        Analyzer analyzer= new Analyzer();
        for (int i = 0; i <args.length ; i++) {
            if(args[i].equals("-a")){
                analyzer.setIndexx(5);
                log.info("programm run with  "+args[i]+" parameter ");
            }
        }
        try {
            article = analyzer.getting(analyzer.getAtricles());
            log.info("size of tge article list= "+article.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}