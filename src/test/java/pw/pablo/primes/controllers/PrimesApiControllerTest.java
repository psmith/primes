package pw.pablo.primes.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value=PrimesApiController.class, secure=false)
public class PrimesApiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void isFourPrime() throws Exception{
        MockHttpServletResponse response = getCall("/primes/4");;

        System.out.println(response);
        String expected = "{number:4,prime:false}";

        JSONAssert.assertEquals(expected, response
                .getContentAsString(), false);

       assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void isThreePrime() throws Exception{

        MockHttpServletResponse response = getCall("/primes/3");

        System.out.println(response);
        String expected = "{number:3,prime:true}";

        JSONAssert.assertEquals(expected, response
                .getContentAsString(), false);

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    private MockHttpServletResponse getCall(String path) throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                path).accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        return result.getResponse();
    }
}
