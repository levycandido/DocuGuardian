package com.docuguardian.web.rest;

import com.docuguardian.service.ProdutoService;
import com.docuguardian.service.dao.NodeHashSetDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class Component {

    private final ProdutoService produtoService;

    @GetMapping("/v1/product/components")
    public ResponseEntity<Set<String>> getComponents(
            @RequestBody NodeHashSetDTO nodeHashSetDTO
    ) {
        var result = produtoService.getComponents(nodeHashSetDTO);
        return ResponseEntity.created(URI.create("/v1/product/components"))
                .header("Custom-Header", "foo")
                .body(result);

    }

}