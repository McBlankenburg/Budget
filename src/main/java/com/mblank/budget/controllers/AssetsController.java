package com.mblank.budget.controllers;

import com.mblank.budget.services.AssetsService;
import com.mblank.budget.services.dtos.AssetsDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assets")
public class AssetsController {
    private final AssetsService assetsService;

    public AssetsController(AssetsService assetsService) {
        this.assetsService = assetsService;
    }

    @GetMapping
    public AssetsDto getAssets(){
        return assetsService.getAllAssets();
    }
}
