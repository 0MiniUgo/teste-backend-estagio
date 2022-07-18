package com.hugo.testebackendestagio.resources;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hugo.testebackendestagio.entities.Equipment;
import com.hugo.testebackendestagio.services.EquipmentService;

@RestController
@RequestMapping(value = "/equipments")
public class EquipmentResource {
    
    @Autowired
    private EquipmentService service;

    @GetMapping
    public ResponseEntity<List<Equipment>> findAll(){
        List<Equipment> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Equipment> findById(@PathVariable UUID id){
        Equipment equipment = service.findById(id);
        return ResponseEntity.ok(equipment);
    }

    @PostMapping
    public ResponseEntity<Equipment> insert(@RequestBody Equipment equipment){
        equipment = service.insert(equipment);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(equipment.getId()).toUri();

        return ResponseEntity.created(uri).body(equipment);
    }
}