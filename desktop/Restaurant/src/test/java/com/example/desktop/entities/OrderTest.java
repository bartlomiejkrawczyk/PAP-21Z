package com.example.desktop.entities;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.Vector;

public class OrderTest {

    @Test
    public void testConstructorAndSetters(){
        Long num1 = -7777777L;
        Long num2 = 666666L;
        Long num3 = 1L;
        Long num4 = 22L;

        Ingredient ing1 = new Ingredient(num1, num2, num3, num4);
        Ingredient ing2 = new Ingredient(num4, num3, num2, num1);
        Recipe rec1 = new Recipe(1, "it certainly is", 22);
        Recipe rec2 = new Recipe(666666);
        SpecialRequest sr1 = new SpecialRequest(num1, "dej kamienia", num2);
        SpecialRequest sr2 = new SpecialRequest(num3, "dej amu", num4);
        Employee emp1 = new Employee(num4, "Karol", "Sulkowski", num3);
        Employee emp2 = new Employee(num1, "Adam", "Rogoziński", num4);

        Integer num5 = 22;
        Integer num6 = -7777777;

        // constructor and setters at once to not copy lots of code again
        List<Ingredient> ingList = new Vector<>();
        ingList.add(ing1);
        ingList.add(ing2);
        List<Recipe> recList = new Vector<>();
        recList.add(rec1);
        recList.add(rec2);
        List<SpecialRequest> srList = new Vector<>();
        srList.add(sr1);
        srList.add(sr2);

        Dish d1 = new Dish(num1, "lama", "dir1/dir2/file.jpg",
                22, num2, ingList, recList);
        Dish d2 = new Dish(num1, "lama", "dir1/file.jpg",
                22, num2, ingList, recList);

        Order o = new Order(num1, num2, d1, num3, srList, 22, emp1);

        assertEquals(num1, o.getId());
        assertEquals(num2, o.getDate());
        assertEquals("dir1/dir2/file.jpg", o.getDish().getImagePath());
        assertEquals(num3, o.getReceiptId());
        assertEquals("dej kamienia", o.getRequests().get(0).getRequest());
        assertEquals(num5, o.getStatus());
        assertEquals("Karol", o.getEmployee().getFirstName());

        o.setId((num4));
        o.setDate(num3);
        o.setDish(d2);
        o.setReceiptId(num2);
        srList.remove(0);
        o.setRequests(srList);
        o.setStatus(num6);
        o.setEmployee(emp2);

        assertEquals(num4, o.getId());
        assertEquals(num3, o.getDate());
        assertEquals("dir1/file.jpg", o.getDish().getImagePath());
        assertEquals(num2, o.getReceiptId());
        assertEquals("dej amu", o.getRequests().get(0).getRequest());
        assertEquals(num6, o.getStatus());
        assertEquals("Adam", o.getEmployee().getFirstName());
    }
}
