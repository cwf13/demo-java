package cooc.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoocApplication {

    private final static Logger logger = LoggerFactory.getLogger(CoocApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(CoocApplication.class, args);
        logger.info("http://localhost:" + 80);

    }
}
