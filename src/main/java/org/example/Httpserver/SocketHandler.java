package org.example.Httpserver;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class SocketHandler implements Runnable {

    private Handler defualtHandler;
    private final Socket socket;
    private Map<String, Map<String, Handler>> handlers = new HashMap<>();

    SocketHandler(Socket socket, Map<String, Map<String, Handler>> handlers) {
        this.socket = socket;
        this.handlers = handlers;

    }

    public void respond(int statusCode, String statusMessage, OutputStream out) throws IOException {
        out.write((STR."HTTP/1.1\{statusCode} \{statusMessage}\r\n").getBytes());
        out.write("\r\n".getBytes());

    }

    @Override
    public void run() {
        BufferedReader in = null;
        OutputStream out = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedOutputStream(socket.getOutputStream());

            Request request = new Request(in);
            if (!request.parse()) {
                respond(500, "server error: cant parse the requested URL", out);
                return;
            }
            Response response = new Response(out);
            boolean foundHandler = false;
            Map<String, Handler> methodHandlers = handlers.get(request.getMethod());
            if (methodHandlers == null) {
                respond(405, "Method not supported", out);
                return;
            }
            for (String handlerPath : handlers.keySet()) { /* Return non-null key*/
                if (handlerPath.equals(request.getPath())) {
                    methodHandlers.get(request.getPath()).Handle(request, response);
                    response.send();
                    foundHandler = true;
                    break;
                }

            }
            if (!foundHandler) {
                if (methodHandlers.get("/*") != null) {
                    methodHandlers.get("/*").Handle(request, response);
                    response.send();
                } else {
                    respond(404, "requested page not found", out);
                }

            }


        } catch (IOException e) {
            try {
                e.printStackTrace();
                if (socket != null) {
                    assert out != null;
                    respond(500, "internal server error", out);

                }
            } catch (IOException e1) {
                try {
                    e1.printStackTrace();
                    if (socket != null) socket.close();
                    if (in != null) in.close();
                    if (out != null) out.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }
}
