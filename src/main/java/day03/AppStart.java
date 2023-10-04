package day03;


import day02.WebStart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class AppStart {

    public static void main(String[] args) {
        SpringApplication.run( AppStart.class );
    }
}
