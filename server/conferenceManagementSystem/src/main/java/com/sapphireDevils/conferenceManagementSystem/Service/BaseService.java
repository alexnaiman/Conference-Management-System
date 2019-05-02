package com.sapphireDevils.conferenceManagementSystem.Service;

import com.sapphireDevils.conferenceManagementSystem.Model.BaseEntity;
import com.sapphireDevils.conferenceManagementSystem.Repository.BaseRepository;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseService<T extends BaseEntity> {
    public abstract BaseRepository<T> getRepository();

    public abstract Class<?> getBaseDtoClass();

    protected ModelMapper modelMapper;

    public BaseService() {
        this.modelMapper = new ModelMapper();
    }

    public Object mapToBasicDtoClass(T entity) {
        return modelMapper.map(entity, getBaseDtoClass());
    }

    public Object create(T entity) {
        entity.setId(0);
        return modelMapper.map(getRepository().save(entity), getBaseDtoClass());
    }

    public Object update(T entity) {
        return getRepository().findById((entity.getId()))
                .map(item -> modelMapper.map(getRepository().save(entity), getBaseDtoClass()))
                .orElse(null);
    }

    public <E> E getOne(int id, Class<E> eClass) {
        return getRepository().findById(id).map((entity) -> modelMapper.map(entity, eClass)).orElse(null);
//        return modelMapper.map(getRepository().findById(id), eClass);
    }

    public <E> List<E> getAll(Class<E> eClass) {
        List<E> list = new ArrayList<>();
        getRepository().findAll().forEach((item) -> list.add(modelMapper.map(item, eClass)));
        return list;
    }

    public List<T> getAll() {
        return getRepository().findAll();
    }

    public T getOne(int id) {
        return getRepository().getOne(id);
    }

    public void delete(int id) {
        getRepository().deleteById(id);
    }

}
