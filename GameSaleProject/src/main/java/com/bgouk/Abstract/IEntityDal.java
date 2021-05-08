package com.bgouk.Abstract;

import java.util.ArrayList;
import java.util.function.Predicate;

public interface IEntityDal<T extends Entity>  {
    void Add(T entity);
    void Update(T entity);
    void Delete(T entity);
    T Get(Predicate<T> predicate);
    ArrayList<T> GetAll(Predicate<T> predicate );
    ArrayList<T> GetAll();

}
