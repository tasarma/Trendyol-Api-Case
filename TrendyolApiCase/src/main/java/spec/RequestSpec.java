package spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.http.client.methods.RequestBuilder;

public class RequestSpec {

    RequestSpecification requestSpecification;

    private final String baseUrl = "https://api.spotify.com/v1";
    private String authToken = "BQCf3uZz6514thsK6zmMaKhdQKpbCRg9cdscKJZRjot-pmxepCEHX4P8FsVsxxRD4l-5hRG9hesdFnRR9fsvuWIs4skzpmwBz6epIkdq_HPnsqO7XpwUYcIq_6mcawEAca0AeS8LV7IWuLQkUXfdcvhjWBOlAHFDFgj15dJDGd9n9n_K1xjyfAUlWPA4MYGhqIa2R-a_fT4I34HQoFcEsYj4Pso54uL2tupnjQStI6o-Dmvl_puUAJ9_t0o4_UxOKG06O8Jyf2T9sofXP4EdARIKH2m1yhN2HSxI2tjB";

    public RequestSpec(String continuationOFBaseUrl){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUrl + continuationOFBaseUrl)
                .addHeader("Authorization","Bearer " +authToken)
                .setContentType("application/json")
                .build();
    }

    public RequestSpecification getRequestSpecification(){
        return requestSpecification;
    }
}
