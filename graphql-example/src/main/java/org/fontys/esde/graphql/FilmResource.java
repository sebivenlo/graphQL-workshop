package org.fontys.esde.graphql;

import io.smallrye.graphql.api.Context;
import org.eclipse.microprofile.graphql.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@GraphQLApi
public class FilmResource {

    @Inject
    GalaxyService service;
    Context context;

    @Query("allFilms")
    @Description("Get all Films from a galaxy far far away")
    public List<Film> getAllFilms() {
        return service.getAllFilms();
    }

    //Query name implicitly set as the method name minus the get
    @Query
    @Description("Get a Film from a galaxy far far away")
    public Film getFilm(@Name("filmId")int id) {
        return service.getFilm(id);
    }



    @Query
    @Description("Get a Hero from a galaxy far far away")
    public Hero getHero(@Name("name") String name) {
        return service.getHero(name);
    }

    @Query
    @Description("Get all heroes with this surname")
    public List<Hero> getHeroesWithSurname(@DefaultValue("Skywalker") String surname) {
        return service.getHeroesBySurname(surname);
    }


    @Mutation
    public Hero createHero(Hero hero) {
        service.addHero(hero);
        return hero;
    }

    @Mutation
    public Hero deleteHero(int id) {
        return service.deleteHero(id);
    }

}
