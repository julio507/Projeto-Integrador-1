package com.yard.stockmanager.persistence.dao;

public interface Dao<T>
{
    public void add(T t);

    public T get(int id );

    public void delete( int id );

    public void update( T t );
}
