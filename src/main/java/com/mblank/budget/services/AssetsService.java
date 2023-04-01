package com.mblank.budget.services;

import com.mblank.budget.services.dtos.AssetsDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class AssetsService {

    public AssetsDto getAllAssets() {
        var assetsDto = new AssetsDto();
        assetsDto.setAssets(Arrays.asList(1, 3, 5));
        return assetsDto;
    }
}
