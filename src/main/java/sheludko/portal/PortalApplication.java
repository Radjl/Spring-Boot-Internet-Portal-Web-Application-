package sheludko.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"controllers","controllers","models","services","repository","config"})
@EnableJpaRepositories("repository")
@EntityScan("models")
public class PortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class, args);



    }
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}

