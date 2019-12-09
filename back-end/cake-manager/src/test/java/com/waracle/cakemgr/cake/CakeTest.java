package com.waracle.cakemgr.cake;

import static junit.framework.TestCase.assertFalse;
import org.junit.Test;
import com.waracle.cakemgr.cake.Model.Cake;

public class CakeTest {
    
	@Test
    public void shouldGenerateDifferentIds() {
        Cake cake1 = new Cake("Title 101", "Description 101", "Image 101");
        Cake cake2 = new Cake("Title 102", "Description 102", "Image 102");

        assertFalse(cake1.getId().equals(cake2.getId()));
    }
}
