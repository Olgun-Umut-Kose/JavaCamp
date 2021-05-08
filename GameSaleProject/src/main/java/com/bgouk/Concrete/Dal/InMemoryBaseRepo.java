package com.bgouk.Concrete.Dal;

import com.bgouk.Abstract.Entity;
import com.bgouk.Abstract.IEntityDal;
import com.sun.mail.util.LineInputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class InMemoryBaseRepo<T extends Entity> implements IEntityDal<T> {
    private final List<T> entities = new ArrayList<T>();

    @Override
    public void Add(T entity) {
        entities.add(entity);
    }

    @Override
    public abstract void Update(T entity);

    @Override
    public void Delete(T entity) {
        Entity deletedEntity = Get(e -> e.getId() == entity.getId());
        entities.remove(deletedEntity);
    }

    @Override
    public T Get(Predicate<T> predicate) {

        return entities.stream().filter(predicate).findFirst().get();
    }

    @Override
    public ArrayList<T> GetAll(Predicate<T> predicate) {
        return (ArrayList<T>) entities.stream().filter(predicate).toList();
    }

    @Override
    public ArrayList<T> GetAll() {
        return (ArrayList<T>) entities;
    }
}
