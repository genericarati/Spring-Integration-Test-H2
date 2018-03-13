package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@RestController
public class HelloController {


    GetData getData;

    @Autowired
    public HelloController(GetData getData) {
        this.getData = getData;
    }


    @RequestMapping("/")
    public String index() throws SQLException {
        getData.createStoredProc();
        return "Greetings from Spring Boot!";
    }

}