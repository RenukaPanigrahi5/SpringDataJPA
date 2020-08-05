package com.spring.emp.dept;

import com.hackerrank.test.utility.Order;
import com.hackerrank.test.utility.OrderedTestRunner;
import com.hackerrank.test.utility.ResultMatcher;
import com.hackerrank.test.utility.TestWatchman;
import com.spring.emp.dept.util.ObjectToJSONConverter;

import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(OrderedTestRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ComparatorControllerTest {

    @ClassRule
    public static final SpringClassRule springClassRule = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();
    
    @Rule
    public TestWatcher watchman = TestWatchman.watchman;
    
    @Autowired
    private MockMvc mockMvc;

    @BeforeClass
    public static void setUpClass() {
        TestWatchman.watchman.registerClass(ComparatorControllerTest.class);
    }

    @AfterClass
    public static void tearDownClass() {
        TestWatchman.watchman.createReport(ComparatorControllerTest.class);
    }

    /**
     *
     * @throws Exception
     *
     * It tests creating trade
     */
    @Test
    @Order(1)
    public void createCompany() throws Exception {
        /**
         *
         * Create trade with id 1
         *
         * The request body is:
         * {
         *     "id": 1,
         *     "type": "buy",
         *     "user": {
         *         "id": 2,
         *         "name": "Amy Palmer"
         *     },
         *     "symbol": "AA",
         *     "shares": 11,
         *     "price": 174.82,
         *     "timestamp": "2018-12-28 13:18:48"
         * }
         */
        //String json = "{\"id\": 1, \"type\": \"buy\", \"user\": {\"id\": 2, \"name\": \"Amy Palmer\"}, \"symbol\": \"AA\", \"shares\": 11, \"price\": 174.82, \"timestamp\": \"2018-12-28 13:18:48\"}";
    	String json = ObjectToJSONConverter.getJSONFormatForCompany();
        mockMvc.perform(
                post("/createCompany")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        ).andExpect(status().isCreated());

      
    }
}
