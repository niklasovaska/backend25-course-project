package fi.haagahelia.courseproject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Long> {
    List<Album> findByTitle(String title);
}
