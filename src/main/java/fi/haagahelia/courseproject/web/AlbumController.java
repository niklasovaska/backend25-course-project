package fi.haagahelia.courseproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fi.haagahelia.courseproject.domain.Album;
import fi.haagahelia.courseproject.domain.AlbumRepository;
import fi.haagahelia.courseproject.domain.Artist;
import fi.haagahelia.courseproject.domain.ArtistRepository;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class AlbumController {

    private AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Autowired
    private ArtistRepository artistRepository;

    // Get all albums
    @GetMapping("/albumlist")
    public String getAlbumList(Model model) {
        model.addAttribute("albums", albumRepository.findAll());
        model.addAttribute("artists", artistRepository.findAll());
        return "albumlist";
    }

    // Add album
    @GetMapping("/addalbum")
    public String addAlbum(Model model) {
        model.addAttribute("album", new Album());
        model.addAttribute("artists", artistRepository.findAll());
        return "addalbum";
    }

    // Save album
    @PostMapping("/savealbum")
    public String save(Album album) {
        albumRepository.save(album);
        return "redirect:/albumlist";
    }
    

    // Edit album
    @GetMapping("edit/{id}")
    public String editAlbum(@PathVariable("id") Long albumId, Model model) {
        model.addAttribute("album", albumRepository.findById(albumId));
        model.addAttribute("artists", artistRepository.findAll());
        return "editalbum";
    }


    


    

}
