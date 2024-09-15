package ek.declaration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpServer;
import ek.declaration.handler.HandlerJSON;
import ek.declaration.model.*;
import ek.declaration.services.DeclarationService;
import ek.declaration.services.SQLConnectService;

import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Endpoint extends HandlerJSON {

    HttpServer server;
    ObjectMapper objectMapper;
    DeclarationService declarationService;
    public static ResponseEntity<String> responseEntity = null;

    public Endpoint(HttpServer server) {
        this.server = server;
        this.objectMapper = new ObjectMapper();
    }

    public void createServerContext() {
        System.out.println("Declareate Beer Service Start");
        server.createContext("/api/beer_decalration", (exchange -> {
            // проверка на POST
            if (!"POST".equals(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed
                exchange.close();
                return;
            }

            byte[] response;
            Headers requestHeaders = exchange.getRequestHeaders();
            String method = requestHeaders.get("method").get(0);
            String user = requestHeaders.get("user").get(0);
            String pass = requestHeaders.get("pass").get(0);
            String url = requestHeaders.get("url").get(0);
            String database = requestHeaders.get("database").get(0);
//          String debug = exchange.getRequestHeaders().get("debug").get(0);

            try {
                Statement statement = SQLConnectService.getConnect(user, pass, url, database);
                declarationService = new DeclarationService(statement);
                System.out.println("doPost starting");
                try (InputStreamReader reader = new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8)) {
                    responseEntity = doPost(reader, method);
                }
            } catch (SQLException e) {
                responseEntity = new ResponseEntity<>("SQLException",
                        getHeaders(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON), StatusCode.NOT_FOUND);
                throw new RuntimeException(e);
            }

            OutputStream os = exchange.getResponseBody();

            exchange.getResponseHeaders().putAll(responseEntity.getHeaders());
            exchange.sendResponseHeaders(responseEntity.getStatusCode().getCode(), 0);
            response = super.writeResponse(responseEntity.getBody());
            os.write(response);
            os.flush();
            os.close();
            exchange.close();
        }));
        server.setExecutor(null); // creates a default executor
        server.start();
    }


    public static Map<String, List<String>> splitQuery(String query) {
        if (query == null || query.isEmpty()) {
            return Collections.emptyMap();
        }

        return Pattern.compile("&").splitAsStream(query)
                .map(s -> Arrays.copyOf(s.split("="), 2))
                .collect(groupingBy(s -> decode(s[0]), mapping(s -> decode(s[1]), toList())));

    }

    private static String decode(final String encoded) {
        try {
            return encoded == null ? null : URLDecoder.decode(encoded, "UTF-8");
        } catch (final UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 is a required encoding", e);
        }
    }

    public ResponseEntity<String> doPost(InputStreamReader is, String clazz) throws IOException, SQLException {
        List<Table> resultList;
        String result = "done";

        switch (clazz) {
            case "nomenclature":
                System.out.println("find header: nomenclature");
                resultList = objectMapper.readValue(new BufferedReader(is)
                        .lines()
                        .collect(Collectors.joining("\n")), new TypeReference<List<Nomenklature>>() {
                });
                declarationService.sendNomenclature(resultList);
                break;

            case "storage":
                System.out.println("find header: storage");
                resultList = objectMapper.readValue(new BufferedReader(is)
                        .lines()
                        .collect(Collectors.joining("\n")), new TypeReference<List<Storage>>() {
                });
                declarationService.sendStorage(resultList);
                break;

            case "suppliers":
                System.out.println("find header: suppliers");
                resultList = objectMapper.readValue(new BufferedReader(is)
                        .lines()
                        .collect(Collectors.joining("\n")), new TypeReference<List<Suppliers>>() {
                });
                declarationService.sendSuppliers(resultList);
                break;

            case "receipts":
                System.out.println("find header: receipts");
                resultList = objectMapper.readValue(new BufferedReader(is)
                        .lines()
                        .collect(Collectors.joining("\n")), new TypeReference<List<Receipts>>() {
                });
                declarationService.sendReceipts(resultList);
                break;

            case "ostatki":
                System.out.println("find header: ostatki");
                resultList = objectMapper.readValue(new BufferedReader(is)
                        .lines()
                        .collect(Collectors.joining("\n")), new TypeReference<List<Ostatki>>() {
                });
                declarationService.sendOstatki(resultList);
                break;

            case "sales":  //--------------------
                System.out.println("find header: sales");
                resultList = objectMapper.readValue(new BufferedReader(is)
                        .lines()
                        .collect(Collectors.joining("\n")), new TypeReference<List<Sales>>() {
                });
                declarationService.sendSales(resultList);
                break;

            default:
                System.out.println("not found header :(");
                return new ResponseEntity<>("404 NOT FOUND",
                        getHeaders(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON), StatusCode.NOT_FOUND);
        }

        SQLConnectService.connectionClose();
        System.out.println(result);
        return new ResponseEntity<>(result, getHeaders(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON), StatusCode.OK);
    }

}
