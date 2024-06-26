package com.sapphireDevils.conferenceManagementSystem.Controller;

import lombok.Data;

@Data
public class Response {

    private Object data;
    private String status;

    public Response(Object object) {
        this.data = object;
        this.status = "success";
    }

    public Response() {

    }

    public static Response getErrorResponse(String message) {
        Response response = new Response();
        response.setStatus("error");
        response.setData(message);
        return response;
    }
}
