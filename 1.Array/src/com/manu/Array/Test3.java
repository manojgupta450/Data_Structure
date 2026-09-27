package com.manu.Array;

public class Test3 {

    public static void main(String[] args) {
       /* String images = "dmp-docker-development.repo.prod.us-west-2.aws.fico.com/fico/falconx-standalone-contextual-data-service";
        //images[0].substring(0, images[0].indexOf('fico/') - 1)
        String dockerRegistry = images.substring(0, images.indexOf("fico/") - 1);
        System.out.println(dockerRegistry);

        dockerRegistry = dockerRegistry.substring(0, dockerRegistry.indexOf(".repo.prod")) + "-registry-prod-repo";

        //dmp-docker-development-registry-prod-repo

        System.out.println(dockerRegistry);*/


        try {
            test();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void test() throws Exception {
        int statusCode = 404;
        throw new Exception("API returned " + statusCode + " and it wasn't handled by the RestTemplate error handler");
    }
}
