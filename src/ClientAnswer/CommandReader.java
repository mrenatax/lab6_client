package ClientAnswer;

import ClientReceiver.ReceiveDataFromServer;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.*;
import java.nio.*;
import static ClientAnswer.ComplicatedCommands.*;
public class CommandReader {
  private boolean isConnected = false;
  public CommandReader() throws IOException {}
  private SocketChannel createChannel() throws IOException {
      ByteBuffer bf = ByteBuffer.allocate(16384);
      SocketChannel socketChannel = SocketChannel.open();
      socketChannel.configureBlocking(true);
      SocketAddress socketAddress = new InetSocketAddress("localhost", 55665);
      try {
          socketChannel.connect(socketAddress);
      }catch (ConnectException e){
          createChannel();
      }
      return socketChannel;
  }
      /**
       * Метод Start считывает введённую пользователем команду и вызывает соответстующий метод из класса Commands; выбрасывает исключения при некорректном пользовательском вводе
       * @exception IllegalStateException в случае выбрасывания данного исключения программа завершается
       */
        public void Start() throws IOException {
            while (!isConnected) {
                isConnected = true;
                ArrayList<String> history = new ArrayList<>();
                Scanner scanner = new Scanner(System.in);
                String commandName = "";
                System.out.println("Введите команду для выполнения. Чтобы узнать все доступные команды введите 'help'");
                try {
                    while (!commandName.equals("exit")) {
                        commandName = scanner.nextLine();
                        commandName = commandName.trim();
                        String[] commandsArray = commandName.trim().split(" ", 2);
                        switch (commandsArray[0]) {
                            case "info":
                                SocketChannel socketchannel = createChannel(); // 2 new lines 2 try
                                ObjectOutputStream outputStream = new ObjectOutputStream(socketchannel.socket().getOutputStream());
                                ReceiveDataFromServer receiveDataFromServer = new ReceiveDataFromServer();
                                history.add(commandName);
                                ComplicatedObject info = new ComplicatedObject("info");
                                outputStream.writeObject(info);
                                receiveDataFromServer.receive();
                                socketchannel.close();
                                outputStream.close();
                                break;
                            case "help":
                                SocketChannel socketchannel1 = createChannel(); // 2 new lines 2 try
                                ObjectOutputStream outputStream1 = new ObjectOutputStream(socketchannel1.socket().getOutputStream());
                                ReceiveDataFromServer receiveDataFromServer1 = new ReceiveDataFromServer();
                                history.add(commandName);
                                ComplicatedObject help = new ComplicatedObject("help");
                                outputStream1.writeObject(help);
                                receiveDataFromServer1.receive();
                                socketchannel1.close();
                                outputStream1.close();
                                break;
                            case "head":
                                SocketChannel socketchannel2 = createChannel(); // 2 new lines 2 try
                                ObjectOutputStream outputStream2 = new ObjectOutputStream(socketchannel2.socket().getOutputStream());
                                ReceiveDataFromServer receiveDataFromServer2 = new ReceiveDataFromServer();
                                history.add(commandName);
                                ComplicatedObject head = new ComplicatedObject("head");
                                outputStream2.writeObject(head);
                                receiveDataFromServer2.receive();
                                socketchannel2.close();
                                outputStream2.close();
                                break;
                            case "clear":
                                SocketChannel socketchannel3 = createChannel(); // 2 new lines 2 try
                                ObjectOutputStream outputStream3 = new ObjectOutputStream(socketchannel3.socket().getOutputStream());
                                ReceiveDataFromServer receiveDataFromServer3 = new ReceiveDataFromServer();
                                history.add(commandName);
                                ComplicatedObject clear = new ComplicatedObject("clear");
                                outputStream3.writeObject(clear);
                                receiveDataFromServer3.receive();
                                socketchannel3.close();
                                outputStream3.close();
                                break;
                            case "show":
                                SocketChannel socketchannel4 = createChannel(); // 2 new lines 2 try
                                ObjectOutputStream outputStream4 = new ObjectOutputStream(socketchannel4.socket().getOutputStream());
                                ReceiveDataFromServer receiveDataFromServer4 = new ReceiveDataFromServer();
                                history.add(commandName);
                                ComplicatedObject show = new ComplicatedObject("show");
                                outputStream4.writeObject(show);
                                receiveDataFromServer4.receive();
                                socketchannel4.close();
                                outputStream4.close();
                                break;
                            case "add":
                                history.add(commandName);
                                System.out.println("Введите имя NAME нового SpaceMarine:");
                                ComplicatedObject co = new ComplicatedObject("add", add());
                                SocketChannel socketchannel5 = createChannel(); // 2 new lines 2 try
                                ObjectOutputStream outputStream5 = new ObjectOutputStream(socketchannel5.socket().getOutputStream());
                                ReceiveDataFromServer receiveDataFromServer5 = new ReceiveDataFromServer();
                                outputStream5.writeObject(co);
                                receiveDataFromServer5.receive();
                                socketchannel5.close();
                                outputStream5.close();
                                break;
                            case "update_id":
                                history.add(commandName); //сначала получаю все данные, а потом отправляю
                                ComplicatedObject obj = new ComplicatedObject("update_id", updateIdFirstPart(), updateIdSecondPart());
                                SocketChannel socketchannel6 = createChannel(); // 2 new lines 2 try
                                ObjectOutputStream outputStream6 = new ObjectOutputStream(socketchannel6.socket().getOutputStream());
                                ReceiveDataFromServer receiveDataFromServer6 = new ReceiveDataFromServer();
                                outputStream6.writeObject(obj);
                                receiveDataFromServer6.receive();
                                outputStream6.close();
                                socketchannel6.close();
                                break;
                            case "remove_by_id":
                                SocketChannel socketchannel7 = createChannel(); // 2 new lines 2 try
                                ObjectOutputStream outputStream7 = new ObjectOutputStream(socketchannel7.socket().getOutputStream());
                                ReceiveDataFromServer receiveDataFromServer7 = new ReceiveDataFromServer();
                                history.add(commandName);
                                ComplicatedObject remove = new ComplicatedObject("remove_by_id", removeById());
                                outputStream7.writeObject(remove);
                                receiveDataFromServer7.receive();
                                outputStream7.close();
                                socketchannel7.close();
                                break;
                            case "sum_of_height":
                                SocketChannel socketchannel8 = createChannel(); // 2 new lines 2 try
                                ObjectOutputStream outputStream8 = new ObjectOutputStream(socketchannel8.socket().getOutputStream());
                                ReceiveDataFromServer receiveDataFromServer8 = new ReceiveDataFromServer();
                                history.add(commandName);
                                ComplicatedObject heightSum = new ComplicatedObject("sum_of_height");
                                outputStream8.writeObject(heightSum);
                                receiveDataFromServer8.receive();
                                outputStream8.close();
                                socketchannel8.close();
                                break;
                            case "max_by_name":
                                SocketChannel socketchannel9 = createChannel(); // 2 new lines 2 try
                                ObjectOutputStream outputStream9 = new ObjectOutputStream(socketchannel9.socket().getOutputStream());
                                ReceiveDataFromServer receiveDataFromServer9 = new ReceiveDataFromServer();
                                history.add(commandName);
                                ComplicatedObject maxName = new ComplicatedObject("max_by_name");
                                outputStream9.writeObject(maxName);
                                receiveDataFromServer9.receive();
                                outputStream9.close();
                                socketchannel9.close();
                                break;
                            case "filter_greater_than_height":
                                SocketChannel socketchannel10 = createChannel(); // 2 new lines 2 try
                                ObjectOutputStream outputStream10 = new ObjectOutputStream(socketchannel10.socket().getOutputStream());
                                ReceiveDataFromServer receiveDataFromServer10 = new ReceiveDataFromServer();
                                history.add(commandName);
                                ComplicatedObject filter = new ComplicatedObject("filter_greater_than_height", filterGreater());
                                outputStream10.writeObject(filter);
                                receiveDataFromServer10.receive();
                                outputStream10.close();
                                socketchannel10.close();
                                break;
                            case "remove_greater":
                                SocketChannel socketchannel11 = createChannel(); // 2 new lines 2 try
                                ObjectOutputStream outputStream11 = new ObjectOutputStream(socketchannel11.socket().getOutputStream());
                                ReceiveDataFromServer receiveDataFromServer11 = new ReceiveDataFromServer();
                                history.add(commandName);
                                ComplicatedObject removeGr = new ComplicatedObject("remove_greater", removeGreater());
                                outputStream11.writeObject(removeGr);
                                receiveDataFromServer11.receive();
                                outputStream11.close();
                                socketchannel11.close();
                                break;
                            case "history":
                                SocketChannel socketchannel12 = createChannel(); // 2 new lines 2 try
                                ObjectOutputStream outputStream12 = new ObjectOutputStream(socketchannel12.socket().getOutputStream());
                                ReceiveDataFromServer receiveDataFromServer12 = new ReceiveDataFromServer();
                                history.add(commandName);
                                ComplicatedObject history1 = new ComplicatedObject("history", history.toString());
                                outputStream12.writeObject(history1);
                                receiveDataFromServer12.receive();
                                outputStream12.close();
                                socketchannel12.close();
                                break;
                            case "exit":
                                SocketChannel socketchanne101 = createChannel(); // 2 new lines 2 try
                                ObjectOutputStream outputStream101 = new ObjectOutputStream(socketchanne101.socket().getOutputStream());
                                ComplicatedObject exit = new ComplicatedObject("exit");
                                outputStream101.writeObject(exit);
                                outputStream101.close();
                                socketchanne101.close();
                                break;
                            case "execute_script":
                                history.add(commandName);
                                ComplicatedObject executeScript = new ComplicatedObject("execute_script");
                                SocketChannel socketchanne100 = createChannel(); // 2 new lines 2 try
                                ObjectOutputStream outputStream100 = new ObjectOutputStream(socketchanne100.socket().getOutputStream());
                                ReceiveDataFromServer receiveDataFromServer100 = new ReceiveDataFromServer();
                                outputStream100.writeObject(executeScript);
                                receiveDataFromServer100.receive();
                                outputStream100.close();
                                socketchanne100.close();
                                break;
                            default:
                                System.out.println("Такой команды нет, повторите ввод. Чтобы узнать список доступных команд введите help.");
                        }
                    }
                } catch (IllegalStateException e) {
                    System.out.println("Программа завершена");
                } catch (NoSuchElementException e) {
                    e.getMessage();
                } catch (IOException e) {
                    System.out.println("Удаленный хост принудительно разорвал существующее подключение. Клиенту необходимо повторить подключение.");
                e.printStackTrace();
                }
            }
        }
}
