package com.mblank.budget.services;

import com.mblank.budget.mappers.AssetsMapper;
import com.mblank.budget.repositories.AssetsRepository;
import com.mblank.budget.services.dtos.AssetsDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class AssetsServiceTest {

    private AssetsRepository assetsRepository= new FakeAssetsRepository();
    private AssetsMapper assetsMapper = new AssetsMapper();

    @Test
    void shouldSaveAssetAndReturnListWithOneElementIfThereWasNoSavedAssetsBefore() {
        //given
        var service = new AssetsService(assetsRepository, assetsMapper);
        int asset = 55;
        service.setAsset(asset);

        //when
        AssetsDto result = service.getAllAssets();

        //then
        List<Integer> listOfAssets = result.getAssets();
        Assertions.assertThat(listOfAssets)
                .hasSize(1)
                .containsExactly(asset);
    }

    @Test
    @DisplayName("shouldSaveAssetAndReturnListWithTwoElementsIfThereWasNoSavedAssetsBefore")
    void shouldSaveAssetAndReturnListWithTwoElementsIfThereWasNoSavedAssetsBefore() {
        //given
        var service = new AssetsService(assetsRepository, assetsMapper);
        int assetOne = 1;
        int assetTwo = 2;
        service.setAsset(assetOne);
        service.setAsset(assetTwo);

        //when
        var result = service.getAllAssets();

        //then
        List<Integer> listOfAssets = result.getAssets();
        Assertions.assertThat(listOfAssets)
                .hasSize(2)
                .containsExactly(assetOne, assetTwo);
    }
}