package com.Tienda_IQ2023.service;

import com.Tienda_IQ2023.dao.CategoriaDao;
import com.Tienda_IQ2023.dao.ClienteDao;
import com.Tienda_IQ2023.domain.Categoria;
import com.Tienda_IQ2023.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista = (List<Categoria>) categoriaDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo()); //4= 3A y 1I
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void saveCategoria(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void deleteCategoria(Categoria categoria) {
        categoriaDao.deleteById(categoria.getIdCategoria());
    }

}
