package me.siyoon;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.server.Server;

public class Main {


    public static void main(String[] args) {
        Server server = newServer(8080);

        server.closeOnJvmShutdown();

        server.start().join();
    }

    static Server newServer(int port) {
        return Server.builder()
                     .http(port)
                     .service("/", ((ctx, req) -> {
                         System.out.println("ctx = " + ctx);
                         System.out.println("req = " + req);
                         System.out.println("req = " + req.path());
                         System.out.println("req = " + req.headers().toString());
                         return HttpResponse.of("Hello, Armeria!~!");
                     }))
                     .build();
    }
}
