package endpoints;

public enum  Endpoints {
    GET_REQUEST("https://jsonplaceholder.typicode.com/posts");

    private final String endpoint;

    Endpoints(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
