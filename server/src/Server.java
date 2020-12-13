import java.io.*;

import java.net.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

//Intellij Idea при длинной записи оператора сама будет выставлять переносы строк, нет необходимости нажимать Enter по середине записи строки.
    String[] adList = {"Пример ответа сервера 1", " Пример ответа сервера 2", " Пример ответа сервера 3", " Пример ответа сервера 4", " Пример ответа сервера 5", "Пример ответа сервера 6", "Пример ответа сервера 7" };

    public void go() {

       try {

//Приложение будет отслеживать клиентские запросы на порту 5000 на том же компьютере, где выполняется данный код

            ServerSocket serverSock = new ServerSocket(5000);

//Сервер входит в постоянный цикл, ожидая клиентских подключений




            while(true) {

                Socket sock = serverSock.accept();

                PrintWriter writer = new PrintWriter(sock.getOutputStream());

                String advice = getAdvice();

                writer.println(advice);

                writer.close();

                System.out.println( advice);

            }

        } catch(IOException ex) {

           ex.printStackTrace();

        }


    } // Закрываем go

    private String getAdvice() {

        int random = (int) (Math.random() * adList.length);

        return adList[random];

    }

    public static void main(String[] args) {

        Server server = new Server();
        server.go();

    }

}