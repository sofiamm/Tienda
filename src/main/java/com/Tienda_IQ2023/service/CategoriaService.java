package com.Tienda_IQ2023.service;

import com.Tienda_IQ2023.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    public List<Categoria> getCategorias(boolean activos);

    public Categoria getCategoria(Categoria categoria);

    public void saveCategoria(Categoria categoria);

    public void deleteCategoria(Categoria categoria);
}
