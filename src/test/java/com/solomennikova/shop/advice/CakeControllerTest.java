package com.solomennikova.shop.advice;

import com.solomennikova.shop.goods.CakeService;
import com.solomennikova.shop.rest.controller.cake.CakeController;
import com.solomennikova.shop.rest.dto.Cakes;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.AssertionErrors;

public class CakeControllerTest {

    @Test
    void testCakes(){
        CakeService cakeService= Mockito.mock(CakeService.class);
        Cakes cakes=new Cakes();
        //cakes.setCakeList(Collections.emptyList());
        Mockito.doReturn(cakes).when(cakeService).getCakes();
        CakeController cakeController= new CakeController(cakeService);
        Cakes cakes2 = cakeController.cakes();
        AssertionErrors.assertEquals("",cakes2,cakes);
        Mockito.verify(cakeService, Mockito.times(1)).getCakes();
    }


}
