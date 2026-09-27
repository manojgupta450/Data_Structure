package com.manu.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static java.util.Objects.isNull;

public class Test2 {

    private static final Pattern REGEX_CHARS = Pattern.compile("^[\\w.-]*$");

    public static void main(String[] args) {
        Map<String, Map<String, String>> map = new HashMap<>();
        /*Map<String, String> stringMap = new HashMap<>();
        stringMap.put("QualifiedName1", "Sant1");
        stringMap.put("QualifiedName2", "Sant2");

        Map<String, String> stringMap1 = new HashMap<>();
        stringMap1.put("QualifiedName3", "Sant3");


        map.put("customerId", stringMap);
        map.put("transactionId", stringMap1);*/

        //System.out.println(map.values());

        //String str = map.values().stream().map(k -> k.get("QualifiedName3")).toString();

        //System.out.println(str);

        /*for (Map<String, String > map22: map.values()) {
            System.out.println(map22.get("QualifiedName2"));
        }*/
        /*List<String> aggregationStoreNames = new ArrayList<>();

        System.out.println(aggregationStoreNames.toArray(new String[0]));


        //map.get("topologyDefinition.getSourceParentContext()").values().toArray(new String[0]);

        if (isNull(map.get("topologyDefinition.getSourceParentContext()"))) {

        }

         String [] arr = isNull(map.get("topologyDefinition.getSourceParentContext()")) ? map.get("topologyDefinition.getSourceParentContext()").values().toArray(new String[0]) : new String[0];

        System.out.println("str");*/

        /*for (Iterator<Map<String, String>> it = map.values().iterator(); it.hasNext(); ) {
            String str1 = it.next().get("QualifiedName2");

            System.out.println(str1);


        }*/

        if (REGEX_CHARS.matcher("TX1.customerId.111-c1.AA_s030").matches()) {
            System.out.println("matched");
        }
        else {
            System.out.println("No match");
        }


        }

    }

