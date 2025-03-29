package fi.haagahelia.courseproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fi.haagahelia.courseproject.domain.Album;
import fi.haagahelia.courseproject.domain.AlbumRepository;
import fi.haagahelia.courseproject.domain.Artist;
import fi.haagahelia.courseproject.domain.ArtistRepository;


@Controller
public class AlbumController {

    private AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Autowired
    private ArtistRepository artistRepository;

    // Get all albums:
    @GetMapping("/albumlist")
    public String getAlbumList(Model model) {
        model.addAttribute("albums", albumRepository.findAll());
        model.addAttribute("artists", artistRepository.findAll());
        return "albumlist";
    }
    

}
