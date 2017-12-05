package com.inventory;

import com.inventory.models.Beverage;
import com.inventory.models.BeverageRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Tibi on 05/12/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeverageRepositoryTests {
    @Autowired
    BeverageRepository br;

    @Test
    public void BeverageRepositoryTest_SaveBeverage() {
        Beverage beverage = new Beverage("Vodka", 10, 90);
        br.save(beverage);
        Assert.assertNotNull(br.findOne(beverage.getId()));

        //make sure we delete the tested beverage
        br.delete(beverage.getId());
    }

    @Test
    public void BeverageRepositoryTest_GetAllBeverages() {
        Assert.assertNotNull(br.findAll());
    }
}
