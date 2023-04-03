package com.mblank.budget.services;

import com.mblank.budget.builders.AssetEntityBuilder;
import com.mblank.budget.mappers.AssetsMapper;
import com.mblank.budget.repositories.AssetsRepository;
import com.mblank.budget.repositories.entities.AssetEntity;
import com.mblank.budget.services.dtos.AssetsDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AssetsServiceTest {

    @Mock
    private AssetsRepository assetsRepository;
    private final AssetsMapper assetsMapper = new AssetsMapper();
    private AssetsService service;

    @BeforeEach
    public void init(){
        service = new AssetsService(assetsRepository, assetsMapper);
    }

    @Test
    void shouldReturnListWithTwoElementsIfThereIsOneElementInDatabase() {
        //given
        int asset = 55;
        AssetEntity assetEntity = new AssetEntityBuilder()
                .withAmount(new BigDecimal(asset))
                .build();

        List<AssetEntity> assetList = Collections.singletonList(assetEntity);
        Mockito.when(assetsRepository.findAll()).thenReturn(assetList);

        //when
        AssetsDto result = service.getAllAssets();

        //then
        List<Integer> listOfAssets = result.getAssets();
        Assertions.assertThat(listOfAssets)
                .hasSize(1)
                .containsExactly(asset);
    }

    @Test
    void shouldReturnListWithTwoElementsIfThereIsTwoElementInDatabase() {
        //given
        int assetOne = 1;
        int assetTwo = 2;

        AssetEntity entityOne = new AssetEntityBuilder()
                .withAmount(new BigDecimal(assetOne))
                .build();

        AssetEntity entityTwo = new AssetEntityBuilder()
                .withAmount(new BigDecimal(assetTwo))
                .build();

        List<AssetEntity> assetList = Arrays.asList(entityOne, entityTwo);
        Mockito.when(assetsRepository.findAll()).thenReturn(assetList);

        //when
        var result = service.getAllAssets();

        //then
        List<Integer> listOfAssets = result.getAssets();
        Assertions.assertThat(listOfAssets)
                .hasSize(2)
                .containsExactly(assetOne, assetTwo);
    }

    @Test
    void shouldVerifyIfTheRepositorySaveWasCalledOneTime() {
        //given
        int asset = 1;
        AssetEntity entity = new AssetEntityBuilder()
                .withAmount(new BigDecimal(asset))
                .build();

        //when
        service.setAsset(asset);

        //then

        Mockito.verify(assetsRepository, Mockito.times(1)).save(entity);
    }
}