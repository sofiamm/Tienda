package com.Tienda_IQ2023.controller;

import com.Tienda_IQ2023.dao.ClienteDao;
import com.Tienda_IQ2023.domain.Cliente;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    ClienteDao clienteDao;

    @GetMapping("/")
    public String inicio(Model model) {
//        log.info("Ahora desde MVC");
//        model.addAttribute("Mensaje", "Hola desde el controlador");
//
//        Cliente cliente = new Cliente("Sofía", "Mora Muñoz", "sofiamoramunoz6@gmail.com", "84568267");
//        model.addAttribute("ObjCliente", cliente);
//
//        Cliente cliente2 = new Cliente("Santiago", "Ureña Muñoz", "santiagourena@gmail.com", "88489200");
//        Cliente cliente3 = new Cliente("Kattia", "Muñoz Araya", "kattiamunozaraya@gmail.com", "88773631");
//
//        List<Cliente> clientes = Arrays.asList(cliente, cliente2, cliente3);
        var clientes = clienteDao.findAll();
        model.addAttribute("listaClientes", clientes);

        return "index";
    }
}
