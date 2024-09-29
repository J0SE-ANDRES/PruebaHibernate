package org.example.repository;

import java.util.List;

/**
 * Interfas que representa el CRUD
 * Crear
 * Leer
 * Actualizar
 * eliminar
 * @param <C> Representa a cualquier entidad definida en el paquete entity
 */
public interface Repository<C> {

    //CRUD
    public void save(C c);
    public List<C> filtrarTodo();
    public C filtrarPorId(long id);
    public void update(C c);
    public void delete(long id);

}
