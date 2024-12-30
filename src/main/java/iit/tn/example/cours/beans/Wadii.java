package iit.tn.example.cours.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Wadii {

    //injection by inteface
    //@Autowired
    private Hello hello;

    //injection by setter
    //@Autowired
    //public void setHello(Hello hello) {
      //  this.hello = hello;
    //}

    //injection by constructor
    public Wadii(Hello hello) {
        this.hello = hello;
    }

    public void sayHi() {
        hello.sayHello();
    }
}
