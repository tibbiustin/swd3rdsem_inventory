package com.inventory;

import com.inventory.models.Order;
import com.inventory.models.OrderRepository;
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
public class OrderRepositoryTests {
    @Autowired
    OrderRepository or;

    @Test
    public void OrderRepositoryTest_SaveOrder() {
        Order order = new Order("supplier name", "Tequila 1L", 10, 9);
        or.save(order);
        Assert.assertNotNull(or.findOne(order.getId()));

        //make sure we delete the tested order
        or.delete(order.getId());
    }

    @Test
    public void OrderRepositoryTest_GetAllOrders() {
        Assert.assertNotNull(or.findAll());
    }
}
