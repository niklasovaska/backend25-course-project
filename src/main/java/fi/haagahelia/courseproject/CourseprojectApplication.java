package fi.haagahelia.courseproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.courseproject.domain.Album;
import fi.haagahelia.courseproject.domain.AlbumRepository;
import fi.haagahelia.courseproject.domain.Artist;
import fi.haagahelia.courseproject.domain.ArtistRepository;

@SpringBootApplication
public class CourseprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseprojectApplication.class, args);
	}

	@Bean
	public CommandLineRunner albumDemo(AlbumRepository albumRepository, ArtistRepository artistRepository) {
		return (args) -> {
			// save test artists
			Artist smile = new Artist("The Smile");
			artistRepository.save(smile);
			Artist kiwanuka = new Artist("Michael Kiwanuka");
			artistRepository.save(kiwanuka);
			Artist fontaines = new Artist("Fontaines D.C.");
			artistRepository.save(fontaines);

			// save test albums
			albumRepository.save(new Album("The Wall of Eyes", smile, 2024, 4.0));
			albumRepository.save(new Album("Small Changes", kiwanuka, 2024, 5.0));
			albumRepository.save(new Album("Romance", fontaines, 2024, 4.5));
			
		};
	}

}
