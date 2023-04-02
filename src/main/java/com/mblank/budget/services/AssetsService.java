package com.mblank.budget.services;

import com.mblank.budget.services.dtos.AssetsDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AssetsService {
    private final AssetsDto assetsDto = new AssetsDto();

    public AssetsDto getAllAssets() {
        return assetsDto;
    }

    public void setAsset(int asset) {
        List<Integer> listOfAssets = assetsDto.getAssets();
        if (listOfAssets == null) {
            listOfAssets = new ArrayList<>();
        }
        listOfAssets.add(asset);
        assetsDto.setAssets(listOfAssets);
    }
}
