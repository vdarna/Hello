/*
package com.example.department.entity;

import org.hibernate.jdbc.Expectations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class EmpTest {

    @InjectMocks
    private Emp emp;

    @Mock
    private List<String> mockedList;

    @Before
    public void setup() {
        // Mockito injects mocks automatically, no need to call initMocks()
    }

    @Test
    public void testGetSample_ProdEnv_ReturnsSuccess() {
        String expectedEnv = "prod";
        List<String> expectedList = new ArrayList<>();
        expectedList.add("app_prod.yml");

        new Expectations() {{
            Emp.getFileList(expectedEnv);
            List<String> result = expectedList;
        }};

        String result = emp.getSample();

        Assert.assertEquals("Success", result);
    }
    @Test
    public void testGetSample_ProdEnv_ReturnsSuccess2() {
        String expectedEnv = "prod";
        List<String> expectedList = new ArrayList<>();
        expectedList.add("app_prod.yml");

        // Mock the getFileList method to return the expected list
        Mockito.when(emp.getFileList(expectedEnv)).thenReturn(expectedList);

        String result = emp.getSample();

        Assert.assertEquals("Success", result);
        // Verify that getFileList was called with the expected environment
        Mockito.verify(emp).getFileList(expectedEnv);
    }

    @Test
    public void testGetSample_NonProdEnv_ReturnsFailure() {
        String expectedEnv = "dev";

        // Mock the getFileList method to return null
        Mockito.when(emp.getFileList(expectedEnv)).thenReturn(null);

        String result = emp.getSample(expectedEnv);

        Assert.assertEquals("Failure", result);
        // Verify that getFileList was called with the expected environment
        Mockito.verify(emp).getFileList(expectedEnv);
    }

    @Test
    public void testGetFileList_ProdEnv_ReturnsCorrectList() {
        String expectedEnv = "prod";
        List<String> expectedList = new ArrayList<>();
        expectedList.add("app_prod.yml");

        // Verify that the actual list returned by getFileList matches the expected list
        Assert.assertEquals(expectedList, emp.getFileList(expectedEnv));
    }

    @Test
    public void testGetFileList_NonProdEnv_ReturnsCorrectList() {
        String expectedEnv = "dev";
        List<String> expectedList = new ArrayList<>();
        expectedList.add("app.yml");

        // Verify that the actual list returned by getFileList matches the expected list
        Assert.assertEquals(expectedList, emp.getFileList(expectedEnv));
    }
}
*/
