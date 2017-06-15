package net.yeah.boot.controller;


import net.yeah.boot.pojo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/index")
public class IndexController {
    @Value("${content}")
    private String content;

    @Autowired
    private People people;

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say() {
        return content + " <br> " + people.toString();
    }

    @RequestMapping(value = "/param1/{id}",method = RequestMethod.GET)
    public String param1 (@PathVariable("id") Integer id) {
        return id + "";
    }

    @RequestMapping(value = "/param2",method = RequestMethod.GET)
    public String param2 (@RequestParam("id") Integer id) {
        return id + "";
    }

    @RequestMapping(value = "/param3",method = RequestMethod.GET)
    public String param3 (@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return id + "";
    }

    @GetMapping(value = "/param4")
    public String param4 (@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return id + "";
    }
}
