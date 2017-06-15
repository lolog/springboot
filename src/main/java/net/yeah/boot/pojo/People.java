package net.yeah.boot.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;

@Component
@ConfigurationProperties(prefix = "people")
public class People {
    private String name;
    @Min(value = 18, message = "未成年人")
    private Integer age;

    People() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People {" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
