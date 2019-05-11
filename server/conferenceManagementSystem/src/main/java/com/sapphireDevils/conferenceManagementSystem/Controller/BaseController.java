package com.sapphireDevils.conferenceManagementSystem.Controller;

import com.sapphireDevils.conferenceManagementSystem.Model.BaseEntity;
import com.sapphireDevils.conferenceManagementSystem.Service.BaseService;
import org.springframework.web.bind.annotation.*;


/**
 * If we need  a simple crud controller we will extend this
 *
 * @param <T>
 */
public abstract class BaseController<T extends BaseEntity> {
    public abstract BaseService<T> getService();


    @GetMapping("/{id}")
    public Response getOne(@PathVariable int id) {
        T entity = getService().getOne(id);
        return new Response(getService().mapToBasicDtoClass(entity));
    }

    @GetMapping
    public Response getAll() {
        return new Response(getService().getAll());
    }

    @PostMapping
    public Response create(@RequestBody T entity) {
        return new Response(getService().create(entity));
    }

    @PutMapping
    public Response update(@RequestBody T entity) {
        return new Response(getService().update(entity));
    }

    @DeleteMapping
    public Response delete(@PathVariable int id) {
        getService().delete(id);
        return new Response(null);
    }

}
