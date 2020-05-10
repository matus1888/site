package com.matus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@SpringBootApplication
public class Application {
    public  static final Logger log= Logger.getLogger(Analyzer.class.getName());
    static List<Article> article;
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);
        Analyzer analyzer= new Analyzer();
        analyzer.method();
        try {
            article = analyzer.getting(analyzer.getAtricles());
            log.info("size of tge article list= "+article.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}