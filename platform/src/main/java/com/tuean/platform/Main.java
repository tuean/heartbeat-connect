package com.tuean.platform;

import com.google.gson.*;
import org.slf4j.MDC;

public class Main {


    public static void main(String[] args) {
        String source = "{\n" +
                "\t\"dynamicProperties\":[\"phone\", \"ClientId\"],\n" +
                "\t\"name\": \"新股中签回访\", \n" +
                "\t\"phones\":[\n" +
                "\t\t{\"phone\":\"13512184317\", \n" +
                "\t\t \"properties\":\n" +
                "\t\t {\n" +
                "\t\t\t \"phone\":{\"text\": \"13512184317\"}, \n" +
                "\t\t\t \"ClientId\": {\"text\": \"99999001\"}\n" +
                "\t\t }\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"rules\":[\n" +
                "\t\t{\n" +
                "\t\t\t\"dayOfWeek\":3, \n" +
                "\t\t\t\"endTime\":\"17:30\",\n" +
                "\t\t\t\"startTime\":\"17:00\"}\n" +
                "\t],\n" +
                "\t\"templateId\":2000033\n" +
                "}";

        JsonObject jsonObject = (JsonObject) new JsonParser().parse(source);
        JsonArray phones = jsonObject.getAsJsonArray("phones");

        for (int index = 0 ; index < 500; index++) {
            String phone = randomPhone();
            String clientId = randomClientId();
            JsonObject tmp = get(phone, clientId);
            phones.add(tmp);
            x++;
        }

        jsonObject.add("phones", phones);
        System.out.println(jsonObject);
    }

    private static Integer x = 1;
    private static String randomPhone() {
        return "8008000" + x;
    }

    private static String randomClientId() {
        return Integer.toString(99999000 + x);
    }

    private static JsonObject get(String phone, String clientId){
        JsonObject properteis = new JsonObject();
        properteis.add("phone", getKey("phone", phone));
        properteis.add("ClientId", getKey("ClientId", clientId));
        JsonObject r = new JsonObject();
        r.addProperty("phone", phone);
        r.add("properties", properteis);
        return r;
    }

    private static JsonObject getKey(String key, String value){
        JsonObject text = new JsonObject();
        text.addProperty("text", value);
        return text;
    }

}
