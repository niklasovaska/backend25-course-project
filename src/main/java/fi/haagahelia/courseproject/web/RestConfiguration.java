package fi.haagahelia.courseproject.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import fi.haagahelia.courseproject.domain.Album;

@Configuration
public class RestConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(
        RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Album.class);
    }
}
