package assignment.assignment1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        ArrayList<Integer> asd = new ArrayList<>();
        asd.add(1);
        asd.add(1);
        asd.add(1);
        asd.add(1);
        asd.add(1);
        List<Integer> sum = asd.stream().map(i ->{
            if(i > 10)
            {
                return i;
            }
            return null;
        }).collect(Collectors.toList());

        SpringApplication.run(AppStart.class);
    }
}
