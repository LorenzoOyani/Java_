package org.example.Httpserver;

public interface Handler {
    void Handle(Request request, Response response);
}
