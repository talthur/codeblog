package com.spring.codeblog.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.ModelRepository;

@Component
public class DummyData {

	
	@Autowired
	ModelRepository modelRepository;
	
	//@PostConstruct
	public void savePosts() {
		
		List<Post> listPost = new ArrayList<>();
		
		Post post1 = new Post();
		post1.setAutor("Arthur");
		post1.setData(LocalDate.now());
		post1.setTitulo("Intro Dark Souls 1");
		post1.setTexto("In the Age of Ancients the world was unformed, shrouded by fog. A land of gray crags, Archtrees and Everlasting Dragons. But then there was Fire and with fire came disparity. Heat and cold, life and death, and of course, light and dark. Then from the dark, They came, and found the Souls of Lords within the flame. Nito, the First of the Dead, The Witch of Izalith and her Daughters of Chaos, Gwyn, the Lord of Sunlight, and his faithful knights. And the Furtive Pygmy, so easily forgotten \n"
				+ "With the strength of Lords, they challenged the Dragons. Gwyn's mighty bolts peeled apart their stone scales. The Witches weaved great firestorms. Nito unleashed a miasma of death and disease. And Seath the Scaleless betrayed his own, and the Dragons were no more. \n"
				+ "Thus began the Age of Fire. But soon the flames will fade and only Dark will remain. Even now there are only embers, and man sees not light, but only endless nights. And amongst the living are seen, carriers of the accursed Darksign. \n"
				+ "Yes, indeed. The Darksign brands the Undead. And in this land, the Undead are corralled and led to the north, where they are locked away, to await the end of the world... This is your fate.");
		
		Post post2 = new Post();
		post2.setAutor("Amanda");
		post2.setData(LocalDate.now());
		post2.setTitulo("Intro Dark Souls 2");
		post2.setTexto("Perhaps you've seen it, maybe in a dream.\n"
				+ "A murky, forgotten land.\n"
				+ "A place where souls may mend your ailing mind.\n"
				+ "You will lose everything...\n"
				+ "... once Branded.\n"
				+ "The symbol of the curse.\n"
				+ "An augur of darkness.\n"
				+ "Your past. Your future. Your very light.\n"
				+ "None will have meaning, and you won't even care.\n"
				+ "By then, you'll be something other than human.\n"
				+ "A thing that feeds on souls.\n"
				+ "A Hollow.\n"
				+ "Long ago, in a walled off land, far to the north, a great king built a great kingdom.\n"
				+ "I believe they called it Drangleic.\n"
				+ "Perhaps you're familiar.\n"
				+ "No, how could you be.\n"
				+ "But one day, you will stand before its decrepit gate.\n"
				+ "Without really knowing why...\n"
				+ "Like a moth drawn to a flame.\n"
				+ "Your wings will burn in anguish.\n"
				+ "Time after time.\n"
				+ "For that is your fate.\n"
				+ "The fate of the cursed.");
		
		Post post3 = new Post();
		post3.setAutor("Adelaide");
		post3.setData(LocalDate.now());
		post3.setTitulo("Intro Dark Souls 3");
		post3.setTexto("Yes, indeed. It is called Lothric, where the transitory lands of the Lords of Cinder converge. In venturing north, the pilgrims discover the truth of the old words: \"The fire fades and the lords go without thrones.\" When the link of fire is threatened, the bell tolls, unearthing the old Lords of Cinder from their graves...Aldrich, Saint of the Deep... Farron's Undead Legion, the Abyss Watchers... And the reclusive lord of the Profaned Capital, Yhorm the Giant... Only, in truth... the Lords will abandon their thrones... And the Unkindled will rise. Nameless, accursed Undead, unfit even to be cinder. And so it is, that ash seeketh embers.");
		
		listPost.add(post1);
		listPost.add(post2);
		listPost.add(post3);
		
		for (Post post : listPost) {
			Post postSaved = modelRepository.save(post);
			System.out.println(postSaved.getId());
		}
		
	}
}
