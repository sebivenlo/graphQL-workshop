package org.fontys.esde.graphql;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.ObjIntConsumer;
import java.util.stream.Collectors;



@ApplicationScoped
public class GalaxyService {

    private List<Hero> heroes = new ArrayList<>();

    private List<Film> films = new ArrayList<>();

    public GalaxyService() {
        Film aNewHope = new Film();
        aNewHope.setTitle("A New Hope");
        aNewHope.setReleaseDate(LocalDate.of(1977, Month.MAY, 25));
        aNewHope.setEpisodeID(4);
        aNewHope.setDirector("George Lucas");

        Film theEmpireStrikesBack = new Film();
        theEmpireStrikesBack.setTitle("The Empire Strikes Back");
        theEmpireStrikesBack.setReleaseDate(LocalDate.of(1980, Month.MAY, 21));
        theEmpireStrikesBack.setEpisodeID(5);
        theEmpireStrikesBack.setDirector("George Lucas");

        Film returnOfTheJedi = new Film();
        returnOfTheJedi.setTitle("Return Of The Jedi");
        returnOfTheJedi.setReleaseDate(LocalDate.of(1983, Month.MAY, 25));
        returnOfTheJedi.setEpisodeID(6);
        returnOfTheJedi.setDirector("George Lucas");

        Film thePhantomMenace = new Film();
        thePhantomMenace.setTitle("The Phantom Menace");
        thePhantomMenace.setReleaseDate(LocalDate.of(1999, Month.MAY, 19));
        thePhantomMenace.setEpisodeID(1);
        thePhantomMenace.setDirector("George Lucas");

        Film attackOfTheClones = new Film();
        attackOfTheClones.setTitle("Attack of the Clones");
        attackOfTheClones.setReleaseDate(LocalDate.of(2002, Month.MAY, 16));
        attackOfTheClones.setEpisodeID(2);
        attackOfTheClones.setDirector("George Lucas");

        Film revengeOfTheSith = new Film();
        revengeOfTheSith.setTitle("Revenge of the Sith");
        revengeOfTheSith.setReleaseDate(LocalDate.of(2005, Month.MAY, 19));
        revengeOfTheSith.setEpisodeID(3);
        revengeOfTheSith.setDirector("George Lucas");

        films.add(thePhantomMenace);
        films.add(attackOfTheClones);
        films.add(revengeOfTheSith);
        films.add(aNewHope);
        films.add(theEmpireStrikesBack);
        films.add(returnOfTheJedi);



        Hero luke = new Hero();
        luke.setName("Luke");
        luke.setSurname("Skywalker");
        luke.setHeight(1.7);
        luke.setMass(73);
        luke.setLightSaber(LightSaber.GREEN);
        luke.setDarkSide(false);
        luke.getEpisodeIds().addAll(Arrays.asList(4, 5, 6));

        Hero leia = new Hero();
        leia.setName("Leia");
        leia.setSurname("Organa");
        leia.setHeight(1.5);
        leia.setMass(51);
        leia.setDarkSide(false);
        leia.getEpisodeIds().addAll(Arrays.asList(4, 5, 6));



        Hero vader = new Hero();
        vader.setName("Darth");
        vader.setSurname("Vader");
        vader.setHeight(1.9);
        vader.setMass(89);
        vader.setDarkSide(true);
        vader.setLightSaber(LightSaber.RED);
        vader.getEpisodeIds().addAll(Arrays.asList(4, 5, 6));

        Hero anakin = new Hero();
        anakin.setName("Anakin");
        anakin.setSurname("Skywalker");
        anakin.setHeight(1.9);
        anakin.setMass(89);
        anakin.setDarkSide(false);
        anakin.setLightSaber(LightSaber.BLUE);
        anakin.getEpisodeIds().addAll(Arrays.asList(1, 2, 3));

        Hero obiwan = new Hero();
        obiwan.setName("Obi-Wan");
        obiwan.setSurname("Kenobi");
        obiwan.setHeight(1.82);
        obiwan.setMass(80);
        obiwan.setDarkSide(false);
        obiwan.setLightSaber(LightSaber.BLUE);
        obiwan.getEpisodeIds().addAll(Arrays.asList(1, 2, 3, 4));

        Hero padme = new Hero();
        padme.setName("Padme");
        padme.setSurname("Amidala");
        padme.setHeight(1.65);
        padme.setMass(58);
        padme.setDarkSide(false);
        padme.getEpisodeIds().addAll(Arrays.asList(1, 2, 3));

        Hero yoda = new Hero();
        yoda.setName("Yoda");
        yoda.setSurname("Yoda");
        yoda.setHeight(0.66);
        yoda.setMass(13);
        yoda.setDarkSide(false);
        yoda.setLightSaber(LightSaber.GREEN);
        yoda.getEpisodeIds().addAll(Arrays.asList(1, 2, 3, 5, 6));

        //Define the friendships
        luke.getFriends().addAll(Arrays.asList(leia,obiwan,yoda));
        leia.getFriends().addAll(Arrays.asList(luke,obiwan));
        anakin.getFriends().addAll(Arrays.asList(padme,obiwan));
        obiwan.getFriends().addAll(Arrays.asList(padme,anakin,luke,leia,yoda));
        padme.getFriends().addAll(Arrays.asList(anakin,obiwan,yoda));
        yoda.getFriends().addAll(Arrays.asList(luke,obiwan,padme));

        heroes.add(luke);
        heroes.add(leia);
        heroes.add(vader);
        heroes.add(anakin);
        heroes.add(obiwan);
        heroes.add(padme);
        heroes.add(yoda);

    }

    /**
     * Returns all films in the collection
     * @return
     */
    public List<Film> getAllFilms() {
        return films;
    }

    /**
     * Returns film with given id
     * @param id
     * @return
     */
    public Film getFilm(int id) {
        for (Film film: films) {
            if (film.getEpisodeID() == id){return film;}
        }
        return null;
    }

    /**
     * Returns the first hero with given name
     * @param name
     * @return
     */
    public Hero getHero(String name) {
        for (Hero hero: heroes) {
            if (hero.getName().equals(name)){return hero;}
        }
        return null;
    }

    /**
     * Returns all heroes of the given film
     * @param film
     * @return
     */
    public List<Hero> getHeroesByFilm(Film film) {
        return heroes.stream()
                .filter(hero -> hero.getEpisodeIds().contains(film.getEpisodeID()))
                .collect(Collectors.toList());
    }

    /**
     * Add given hero to collection
     * @param hero
     */
    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    /**
     * Delete hero with given id
     * @param id
     * @return
     */
    public Hero deleteHero(int id) {
        return heroes.remove(id);
    }

    /**
     * Get hero(es) with given Surname
     * @param surname
     * @return
     */
    public List<Hero> getHeroesBySurname(String surname) {
        return heroes.stream()
                .filter(hero -> hero.getSurname().equals(surname))
                .collect(Collectors.toList());
    }
}

