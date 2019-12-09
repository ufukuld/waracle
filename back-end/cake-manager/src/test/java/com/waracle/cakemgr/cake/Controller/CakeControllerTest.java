package com.waracle.cakemgr.cake.Controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.waracle.cakemgr.cake.Model.Cake;
import com.waracle.cakemgr.cake.Service.CakeService;

@RunWith(SpringRunner.class)
@WebMvcTest(CakeController.class)
public class CakeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CakeService cakeRepository;
    
    @Test
    public void shouldReturnCakeListFromService() throws Exception {
    	List<Cake> resultList = new ArrayList<Cake>();
    	resultList.add(new Cake("Title 101", "Description 101", "Image 101"));
    	resultList.add(new Cake("Title 102", "Description 102", "Image 102"));
    	
        when(cakeRepository.getCakeList()).thenReturn(resultList);
        this.mockMvc.perform(get("/cakes"))
        	.andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].title").value("Title 101"))
            .andExpect(jsonPath("$[1].title").value("Title 102"));      
    }
}
