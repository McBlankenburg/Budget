package com.mblank.budget.controllers;

import com.mblank.budget.services.AssetsService;
import com.mblank.budget.services.dtos.AssetDto;
import com.mblank.budget.services.dtos.AssetsDto;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void setAsset(@RequestBody AssetDto dto){
        assetsService.setAsset(dto);
    }
}
