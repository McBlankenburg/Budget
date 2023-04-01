package com.mblank.budget.services;

import com.mblank.budget.services.dtos.AssetsDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class AssetsServiceTest {

    @Test
    void shouldSaveAssetAndReturnListWithOneElementIfThereWasNoSavedAssetsBefore() {
        //given
        var service = new AssetsService();
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
}