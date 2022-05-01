package com.vqmind.vq;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueryTest {
    @Test
    void test_sample() {
        String sample = " {\n" +
                "  \"id\": \"0003\",\n" +
                "  \"type\": \"donut\",\n" +
                "  \"name\": \"Old Fashioned\",\n" +
                "  \"ppu\": 0.55,\n" +
                "  \"batters\":\n" +
                "   {\n" +
                "    \"batter\":\n" +
                "     [\n" +
                "      { \"id\": \"1001\", \"type\": \"Regular\" },\n" +
                "      { \"id\": \"1002\", \"type\": \"Chocolate\" }\n" +
                "     ]\n" +
                "   },\n" +
                "  \"topping\":\n" +
                "   [\n" +
                "    { \"id\": \"5001\", \"type\": \"None\" },\n" +
                "    { \"id\": \"5002\", \"type\": \"Glazed\" },\n" +
                "    { \"id\": \"5003\", \"type\": \"Chocolate\" },\n" +
                "    { \"id\": \"5004\", \"type\": \"Maple\" }\n" +
                "   ]\n" +
                " }";
        Query query = new Query(sample);

        assertEquals("5001", query.find("$.topping[0].id"));
        assertEquals("0003", query.find("$.id"));
        assertEquals("{\"id\":\"1002\",\"type\":\"Chocolate\"}", query.find("$.batters.batter[1]"));

        String pretty = "{\n  \"id\": \"1002\",\n  \"type\": \"Chocolate\"\n}";
        assertEquals(pretty, query.find("pretty($.batters.batter[1])"));
    }
}
