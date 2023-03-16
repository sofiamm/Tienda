package com.Tienda_IQ2023.service;

import com.Tienda_IQ2023.domain.Articulo;
import java.util.List;

public interface ArticuloService {
    public List<Articulo> getArticulos(boolean activos);

    public Articulo getArticulo(Articulo articulo);

    public void saveArticulo(Articulo articulo);

    public void deleteArticulo(Articulo articulo);
}
