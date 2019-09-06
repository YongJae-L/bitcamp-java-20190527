package ch29.j;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * 지정된 패키지를 뒤져서 
 */

//@Configuration
@ComponentScan({"ch29.j","ch29.j2"})
public class AppConfig1 {

}
