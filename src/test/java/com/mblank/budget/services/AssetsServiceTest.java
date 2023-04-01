package com.mblank.budget.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class AssetsServiceTest {

    @Test
    void shouldSaveAssetAndReturnListWithOneElementIfThereWasNoSavedAssetsBefore() {
        //given
        var service = new AssetsService();
        var asset = 1;
        service.setAsset(asset);

        //when
        var result = service.getAllAssets();

        //then
        List<Integer> listOfAssets = result.getAssets();
        Assertions.assertThat(listOfAssets)
                .hasSize(1);
    }
}