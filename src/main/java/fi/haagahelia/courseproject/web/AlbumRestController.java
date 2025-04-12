package fi.haagahelia.courseproject.web;

import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.courseproject.domain.Album;
import fi.haagahelia.courseproject.domain.AlbumRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class AlbumRestController {
    
    private AlbumRepository albumRepository;
    
    private AlbumRestController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    // RESTful service to get all albums
    @GetMapping("/api/v1/albums")
    public @ResponseBody List<Album> getAllAlbumsRest() {
        return (List<Album>) albumRepository.findAll();
    }
    
    // RESTful service to get album by id
    @GetMapping("api/v1/albums/{id}")
    public Optional<Album> findAlbumRest(@PathVariable("id") Long albumId) {
        return albumRepository.findById(albumId);
    }
    
}
