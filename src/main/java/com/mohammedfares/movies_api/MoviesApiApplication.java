package com.mohammedfares.movies_api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mohammedfares.movies_api.models.Movie;
import com.mohammedfares.movies_api.servises.MovieServiceImpl;

@SpringBootApplication
public class MoviesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner comandlineRunner(MovieServiceImpl movieServiceImpl) {
		return (e)->{
			movieServiceImpl.insertMovie(new Movie("Elf", "Raised as an oversized elf, Buddy travels from the North Pole to New York City to meet his biological father, Walter Hobbs, who doesn't know he exists and is in desperate need of some Christmas spirit.", 9.99f, "https://cdn.shopify.com/s/files/1/0057/3728/3618/products/53057_500x749.jpg?v=1604088239", "2003"));
			movieServiceImpl.insertMovie(new Movie("Back to the Future", "Marty McFly, a 17-year-old high school student, is accidentally sent 30 years into the past in a time-traveling DeLorean invented by his close friend, the maverick scientist Doc Brown.", 16.99f, "https://www.movieposters.com/cdn/shop/products/0b2b67a1de6a06d1ce65e4ccc64047e3_a9f7318e-c5c4-4d2a-aed2-890bbfad883c_480x.progressive.jpg?v=1573590273", "2003"));
			movieServiceImpl.insertMovie(new Movie("Pulp Fiction", "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.", 17.99f, "https://www.movieposters.com/cdn/shop/products/950e439404c3d5eddd86ae876cec83bf_949b5045-2503-4883-bcd2-ff1f31f5b14c_480x.progressive.jpg?v=1573588746", "1994"));
			movieServiceImpl.insertMovie(new Movie("Taylor Swift: The Eras Tour", "Experience the Eras Tour concert, performed by the one and only Taylor Swift.", 9.99f, "https://www.movieposters.com/cdn/shop/files/taylor_swift_the_eras_tour_480x.progressive.jpg?v=1695738831", "2003"));
			movieServiceImpl.insertMovie(new Movie("Marilyn Monroe", "Raised as an oversized elf, Buddy travels from the North Pole to New York City to meet his biological father, Walter Hobbs, who doesn't know he exists and is in desperate need of some Christmas spirit.", 9.99f, "https://www.movieposters.com/cdn/shop/products/66a8dbf70e4d072b093c82cbdbfe0e71_d19deab1-6e21-4960-b9f4-e3d044e7e880_480x.progressive.jpg?v=1573585416", "2003"));
			movieServiceImpl.insertMovie(new Movie("Dark Knight","When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",9.99f,"https://www.movieposters.com/cdn/shop/products/darkknight.building.mp_480x.progressive.jpg?v=1648745750","2008"));
			movieServiceImpl.insertMovie(new Movie("It’s a Wonderful Life", "An angel is sent from Heaven to help a desperately frustrated businessman by showing him what life would have been like if he had never existed.", 16.99f, "https://www.movieposters.com/cdn/shop/products/itsawonderfullife24x36_480x.progressive.jpg?v=1617745735", "1946"));
			movieServiceImpl.insertMovie(new Movie("Reservoir Dogs", "When a simple jewelry heist goes horribly wrong, the surviving criminals begin to suspect that one of them is a police informant.", 16.99f, "https://www.movieposters.com/cdn/shop/products/reservoirdogs_480x.progressive.jpg?v=1620680961", "1993"));
			movieServiceImpl.insertMovie(new Movie("Hocus Pocus", "A teenage boy named Max and his little sister move to Salem, where he struggles to fit in before awakening a trio of diabolical witches that were executed in the 17th century.", 16.99f, "https://www.movieposters.com/cdn/shop/products/hocuspocus.24x36_480x.progressive.jpg?v=1615397204", "1993"));
			movieServiceImpl.insertMovie(new Movie("Scream", "A year after the murder of her mother, a teenage girl is terrorized by a masked killer who targets her and her friends by using scary movies as part of a deadly game.", 42.99f, "https://www.movieposters.com/cdn/shop/products/ea468a9659b1bd702645bf54e13bf221_6df235be-52b9-49b6-8afa-bf64341c306b_480x.progressive.jpg?v=1573593688", "1996"));
			movieServiceImpl.insertMovie(new Movie("Home Alone", "An eight-year-old troublemaker, mistakenly left home alone, must defend his home against a pair of burglars on Christmas Eve.", 15.99f, "https://www.movieposters.com/cdn/shop/products/dd43b3a44eacfd9ff0a3d97b311d17d2_b4766a06-e1c1-421d-acdb-3adae5c2c645_480x.progressive.jpg?v=1573652567", "1990"));
			movieServiceImpl.insertMovie(new Movie("Scream", "A year after the murder of her mother, a teenage girl is terrorized by a masked killer who targets her and her friends by using scary movies as part of a deadly game.", 9.99f, "https://www.movieposters.com/cdn/shop/products/c4e98d24676608a9df2a50202ffc690d_b63c992d-6f16-43f0-be32-c5dadb1c6eb9_480x.progressive.jpg?v=1573652511", "1996"));
			movieServiceImpl.insertMovie(new Movie("Halloween", "Fifteen years after murdering his sister on Halloween night 1963, Michael Myers escapes from a mental hospital and returns to the small town of Haddonfield, Illinois to kill again.", 19.99f, "https://www.movieposters.com/cdn/shop/products/halloween.24x36_480x.progressive.jpg?v=1616686637", "1970"));
			movieServiceImpl.insertMovie(new Movie("Ghostbusters", "Three parapsychologists forced out of their university funding set up shop as a unique ghost removal service in New York City, attracting frightened yet skeptical", 16.99f, "https://www.movieposters.com/cdn/shop/products/cedcf0e4209895fce418196e333507ad_54154c41-79c2-4688-93e6-88283b8cfd36_480x.progressive.jpg?v=1573592554", "1984"));
			movieServiceImpl.insertMovie(new Movie("Friday the 13th", "A group of camp counselors trying to reopen a summer camp called Crystal Lake, which has a grim past, are stalked by a mysterious killer.", 14.99f, "https://www.movieposters.com/cdn/shop/products/645af7c9e6060cea0b63b42f17fbbd30_f437bf77-58de-4b8e-b17a-4460853e25cb_480x.progressive.jpg?v=1573651427", "1980"));
			movieServiceImpl.insertMovie(new Movie("Nightmare Before Christmas", "Jack Skellington, king of Halloween Town, discovers Christmas Town, but his attempts to bring Christmas to his home causes confusion.", 10.99f, "https://www.movieposters.com/cdn/shop/products/75bc6cfb4407cd1ba49e8d0319390c89_ee9f2eb6-6b00-4d19-b4f4-119881cbbacf_480x.progressive.jpg?v=1573616168", "1993"));
			movieServiceImpl.insertMovie(new Movie("National Lampoon’s Christmas Vacation", "The Griswold family's plans for a big family Christmas predictably turn into a big disaster.", 9.99f, "https://www.movieposters.com/cdn/shop/files/66d3eedf796dda113fbeb00434dded5f_567e1791-ebce-41c4-9af2-98e47367a3bd_480x.progressive.jpg?v=1697998366", "1989"));
			movieServiceImpl.insertMovie(new Movie("Christmas Story", "In the 1940s, a young boy named Ralphie Parker attempts to convince his parents, teacher, and Santa Claus that a Red Ryder Range 200 Shot BB gun really is the perfect Christmas gift.", 14.99f, "https://www.movieposters.com/cdn/shop/products/christmasstory.styleb_480x.progressive.jpg?v=1617896485", "1983"));
			movieServiceImpl.insertMovie(new Movie("Jurassic Park", "A pragmatic paleontologist touring an almost complete theme park on an island in Central America is tasked with protecting a couple of kids after a power failure causes the park's cloned dinosaurs to run loose.", 9.99f, "https://www.movieposters.com/cdn/shop/products/e50345d7cfee907ad63bb835109b37b9_263eaa00-ac40-4a0e-b2d7-86bb4ac69c90_480x.progressive.jpg?v=1573584652", "1993"));
			movieServiceImpl.insertMovie(new Movie("Trouble in Morocco", "A newspaperman Paul Cluett (Jack Holt) gets rival reporter Linda Lawrence (Mae Clark) to admit that she is investigating a story in Morocco that guns are being smuggled illegally.", 14.99f, "https://www.movieposters.com/cdn/shop/files/troublemoro_480x.progressive.jpg?v=1695832700", "1937"));
			movieServiceImpl.insertMovie(new Movie("Lady Gaga", "lady gaga.", 11.99f, "https://www.movieposters.com/cdn/shop/files/A111_480x.progressive.jpg?v=1702485362", "2003"));
		};
		
	}

}
