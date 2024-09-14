package ek.declaration;

import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;


public class Main {

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(8001), 0);
        Endpoint endpoint = new Endpoint(server);
        endpoint.createServerContext();


//        ObjectMapper objectMapper = new ObjectMapper();
//        List<Table> resultList;
//        resultList = objectMapper.readValue("[\n" +
//                "    {\"nomer\": \"123456\", \"dt\" : \"2022-20-11\" , \"loc\" : \"123\" , \"clientid\" : \"2533\", \"inn\" : \"123456\" , \"kpp\" : \"12354\" , \"naclpost\" : \"1ostko22nec\"\n" +
//                "    , \"chfpost\" : \"f123fdg456\" , \"datachf\" : \"2022-20-11\" , \"article\" : \"454374\" , \"kolvo\" : \"45333\" , \"itprnotax\" : 1234.12345 , \"totprnotax\" : 1234.12345\n" +
//                "    , \"itprice\" : 1234.12345 , \"totprice\" : 1234.12345 , \"taxrate\" : 20.121, \"taxsum\" : 1234.12345  , \"opcode\" : 1234.12345  , \"producer\" : \"1234ss56\" \n" +
//                "    , \"userop\" : 1234.12345  , \"locfrom\" : \"3214fds\", \"reciver\" : \"ostkonec\"}\n" +
//                "] ", new TypeReference<List<Receipts>>(){});
//        resultList.stream().forEach(System.out::println);

//        ObjectMapper objectMapper = new ObjectMapper();
//        Storage s = objectMapper.reader().forType(Storage.class).readValue("{\"loc\": \"1452554.244\"}");
//        System.out.println(s);

//        List<Model> oblist ;
//        oblist = new ArrayList<>();
//        oblist.add(new Receipts());
//
//        if (oblist.get(0) instanceof Storage) {
//
//            System.out.println("11111");
//        }


    }
}