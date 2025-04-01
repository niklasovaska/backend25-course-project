package fi.haagahelia.courseproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fi.haagahelia.courseproject.domain.Album;
import fi.haagahelia.courseproject.domain.AlbumRepository;
import fi.haagahelia.courseproject.domain.Artist;
import fi.haagahelia.courseproject.domain.ArtistRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;






@Controller
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

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
    public String save(@Valid Album album, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("album", album);
            model.addAttribute("artists", artistRepository.findAll());
            return "addalbum";
        }

        albumRepository.save(album);
        return "redirect:/albumlist";
    }
    

    // Edit album
    @GetMapping("edit/{id}")
    public String editAlbum(@PathVariable("id") Long albumId, Model model) {
        Album album = albumRepository.findById(albumId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid album id:" + albumId));

        model.addAttribute(album);
        model.addAttribute("artists", artistRepository.findAll());
        return "editalbum";
    }

    // Update album
    @PostMapping("/update")
    public String updateAlbum(@Valid Album album, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("album", album);
            model.addAttribute("artists", artistRepository.findAll());
            return "editalbum";
        }

        albumRepository.save(album);

        return "redirect:albumlist";
    }

    // Delete album
    @GetMapping("/delete/{id}")
    public String deleteAlbum(@PathVariable("id") Long albumId) {
        albumRepository.deleteById(albumId);
        return "redirect:../albumlist";
    }

    // Add artist
    @GetMapping("/addartist")
    public String addArtist(Model model) {
        model.addAttribute("artist", new Artist());
        model.addAttribute("artists", artistRepository.findAll());
        return "addartist";
    }

    // Save artist
    @PostMapping("/saveartist")
    public String saveArtist(@Valid Artist artist, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("artist", artist);
            model.addAttribute("artists", artistRepository.findAll());
            return "addartist";
        }

        artistRepository.save(artist);
        return "redirect:/albumlist";
    }
    
    
}
