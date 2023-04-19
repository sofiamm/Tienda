package com.Tienda_IQ2023.service;

import com.Tienda_IQ2023.dao.CarritoDao;
import com.Tienda_IQ2023.domain.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    CarritoDao carritoDao;

    @Override
    public Carrito getCarrito(Carrito carrito) {
        return carritoDao.findById(carrito.getIdCarrito()).orElse(null);
    }

    @Override
    public Carrito getCarritoCliente(Long idCliente) {
        //Buscamos si exite carrito para el cliente
        Carrito carritoCliente = carritoDao.findByIdCliente(idCliente).orElse(null);

        //Si no existe el carrito, lo creamos
        if (carritoCliente == null) {
            Carrito carritoNuevo = new Carrito(idCliente);
            carritoCliente = carritoDao.save(carritoNuevo);
        }

        return carritoCliente;
    }

}
