package com.example.dao;

import java.util.List;

public interface CrudDAO<T> {

	void guardar(T t);

    T encontrarPorId(int id);
    
 

    List<T> mostrarTodos();
    
    


    void actualizar(T t);

    void eliminar(T t);

}
