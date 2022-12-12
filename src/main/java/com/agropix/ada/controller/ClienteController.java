package com.agropix.ada.controller;

import com.agropix.ada.dto.ClienteRequest;
import com.agropix.ada.model.Cliente;
import com.agropix.ada.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/clientes")
@AllArgsConstructor
public class ClienteController {

    private ClienteService clienteService;

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody ClienteRequest clienteRequest) {
        Cliente cliente = clienteService.save(clienteRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @GetMapping()
    public CollectionModel<Cliente> getAll() {
        List<Cliente> clienteList = clienteService.findAll();
        for (Cliente cliente : clienteList) {
            cliente.add(linkTo(methodOn(ClienteController.class).getOne(cliente.getId())).withSelfRel());
        }
        CollectionModel<Cliente> clienteCollectionModel = CollectionModel.of(clienteList);
        clienteCollectionModel.add(linkTo(methodOn(ClienteController.class).getAll()).withSelfRel());
        return clienteCollectionModel;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") UUID id) {
        Cliente cliente = clienteService.findById(id);
        cliente.add(linkTo(methodOn(ClienteController.class).getOne(id)).withSelfRel());
        cliente.add(linkTo(methodOn(ClienteController.class).getAll()).withRel(IanaLinkRelations.COLLECTION));
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

}
