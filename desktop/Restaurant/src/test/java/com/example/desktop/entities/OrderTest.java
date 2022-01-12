package com.example.desktop.entities;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.Vector;

public class OrderTest {

    Ingredient ing1 = new Ingredient((long) -7777777, (long) 666666, (long) 1, (long) 22);
    Ingredient ing2 = new Ingredient((long) 22, (long) 1, (long) 666666, (long) -7777777);
    Recipe rec1 = new Recipe(1, "it certainly is", 22);
    Recipe rec2 = new Recipe(666666);
    SpecialRequest sr1 = new SpecialRequest((long) -7777777, "dej kamienia", (long) 666666);
    SpecialRequest sr2 = new SpecialRequest((long) 1, "dej amu", (long) 22);
    Employee emp1 = new Employee((long) 22, "Karol", "Sulkowski", (long) 1);
    Employee emp2 = new Employee((long) -7777777, "Adam", "Rogoziński", (long) 22);

    Long num1 = (long) -7777777;
    Long num2 = (long) 666666;
    Long num3 = (long) 1;
    Long num4 = (long) 22;
    Integer num5 = 22;
    Integer num6 = -7777777;

    @Test
    public void testConstructorAndSetters(){
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

        Dish d1 = new Dish((long) -7777777, "lama", "dir1/dir2/file.jpg",
                22, (long) 666666, ingList, recList);
        Dish d2 = new Dish((long) -7777777, "lama", "dir1/file.jpg",
                22, (long) 666666, ingList, recList);

        Order o = new Order((long) -7777777, (long) 666666, d1, (long) 1, srList, 22, emp1);

        assertEquals(o.getId(), num1);
        assertEquals(o.getDate(), num2);
        assertEquals(o.getDish().getImagePath(), "dir1/dir2/file.jpg");
        assertEquals(o.getReceiptId(), num3);
        assertEquals(o.getRequests().get(0).getRequest(), "dej kamienia");
        assertEquals(o.getStatus(), num5);
        assertEquals(o.getEmployee().getFirstName(), "Karol");

        o.setId((long) 22);
        o.setDate((long) 1);
        o.setDish(d2);
        o.setReceiptId((long) 666666);
        srList.remove(0);
        o.setRequests(srList);
        o.setStatus(-7777777);
        o.setEmployee(emp2);

        assertEquals(o.getId(), num4);
        assertEquals(o.getDate(), num3);
        assertEquals(o.getDish().getImagePath(), "dir1/file.jpg");
        assertEquals(o.getReceiptId(), num2);
        assertEquals(o.getRequests().get(0).getRequest(), "dej amu");
        assertEquals(o.getStatus(), num6);
        assertEquals(o.getEmployee().getFirstName(), "Adam");
    }
}
