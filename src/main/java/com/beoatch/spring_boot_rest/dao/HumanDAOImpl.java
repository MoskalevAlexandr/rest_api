package com.beoatch.spring_boot_rest.dao;

import com.beoatch.spring_boot_rest.entity.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HumanDAOImpl implements HumanDAO {
    private EntityManager entityManager;

    @Autowired
    public HumanDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Human> showPeople() {
        javax.persistence.Query query = entityManager.createQuery("from Human");
        List<Human> people = query.getResultList();
        return people;
    }

    @Override
    public void saveHuman(Human human) {
        entityManager.merge(human);
    }

    @Override
    public Human getHuman(int id) {
        Human human = entityManager.find(Human.class, id);
        return human;
    }

    @Override
    public void deleteHuman(int id) {
        Query query = entityManager.createQuery("delete from Human where id=:humanId");
        query.setParameter("humanId", id);
        query.executeUpdate();
    }

    @Override
    public Object getHumanByDocNumber(int n) {
        Query query = entityManager.createQuery("from Human ");
        List<Human> people = query.getResultList();
        String str = "";
        Human human = null;
        for (Human h: people) {
            if (h.getDoc().getNumber() == n) {
                human = h;
                return human;
            }
        }
        if (human == null) {
            str = "There is no human with number " + n;
            return str;
        }
        return human;
    }

    @Override
    public List<Human> getPeopleByDateOfBirth(LocalDate date) {
        javax.persistence.Query query = entityManager.createQuery("from Human");
        List<Human> people = query.getResultList();
        List<Human> desiredPeople = new ArrayList<>();

        for (Human h: people) {
            if (h.getDateOfBirth().equals(date)) {
                desiredPeople.add(h);
            }
        }
        return desiredPeople;
    }

    @Override
    public List<Human> getPeopleBySNP(String s, String n, String p) {
        javax.persistence.Query query = entityManager.createQuery("from Human");
        List<Human> people = query.getResultList();
        List<Human> desiredPeople = new ArrayList<>();

        for (Human h: people) {
            if (h.getSurname().equals(s) && h.getName().equals(n) && h.getPatronymic().equals(p)) {
                desiredPeople.add(h);
            }
        }
        return desiredPeople;
    }
}