package com.example.restaurant.entities;

import static com.example.restaurant.utils.SerializeUtils.deserialize;
import static com.example.restaurant.utils.SerializeUtils.serialize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import com.example.restaurant.errors.InvalidData;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SpecialRequestTest {

    @Test
    public void specialRequestEmptyConstructor() {
        SpecialRequest specialRequest = new SpecialRequest();
        assertNull(specialRequest.getId());
        assertNull(specialRequest.getRequest());
        assertNull(specialRequest.getOrderId());
    }

    @Test
    public void specialRequestConstructor() {
        SpecialRequest specialRequest = new SpecialRequest(1L, "Without tomato", 1L);
        assertEquals(Long.valueOf(1L), specialRequest.getId());
        assertEquals("Without tomato", specialRequest.getRequest());
        assertEquals(Long.valueOf(1L), specialRequest.getOrderId());
    }

    @Test
    public void specialRequestSetters() {
        SpecialRequest specialRequest = new SpecialRequest();

        specialRequest.setId(1L);
        specialRequest.setRequest("Without tomato");
        specialRequest.setOrderId(1L);

        assertEquals(Long.valueOf(1L), specialRequest.getId());
        assertEquals("Without tomato", specialRequest.getRequest());
        assertEquals(Long.valueOf(1L), specialRequest.getOrderId());

        specialRequest.setId(null);
        specialRequest.setRequest(null);
        specialRequest.setOrderId(null);

        assertNull(specialRequest.getId());
        assertNull(specialRequest.getRequest());
        assertNull(specialRequest.getOrderId());
    }

    @Test
    public void specialRequestSerialize() {
        List<SpecialRequest> requests = Arrays.asList(
                new SpecialRequest(1L, "Without tomato", 1L),
                new SpecialRequest(null, "Without tomato", 1L),
                new SpecialRequest(1L, null, 1L),
                new SpecialRequest(1L, "Without tomato", null),
                new SpecialRequest(null, null, null)
        );
        requests.forEach(specialRequest -> {
            try {
                SpecialRequest output = deserialize(serialize(specialRequest), SpecialRequest.class);
                assertEquals(specialRequest.getId(), output.getId());
                assertEquals(specialRequest.getRequest(), output.getRequest());
            } catch (IOException | ClassNotFoundException e) {
                fail();
            }
        });
    }

    @Test
    public void specialRequestValidateData() {
        List<SpecialRequest> requests = Arrays.asList(
                new SpecialRequest(1L, null, 1L),
                new SpecialRequest(1L, "", 1L),
                new SpecialRequest(1L, "Test", null)
        );

        for (SpecialRequest request : requests)
            assertThrows(InvalidData.class, request::validateData);

        SpecialRequest request = new SpecialRequest(1L, "Test", 1L);
        try {
            request.validateData();
        } catch (InvalidData invalidData) {
            fail();
        }
    }


}
