import ClientAnswer.CommandReader;
import java.io.IOException;
import java.net.ConnectException;
public class Client {
    public static void main(String[] args) throws IOException {
        CommandReader x = new CommandReader();
        try {
            x.Start();
        }catch (ConnectException e){
            System.out.println("Нет связи с сервером...");
        } catch (IOException e){
            System.out.println("Удаленный хост принудительно разорвал существующее подключение. Клиенту необходимо повторить подключение.");
        }
    }
}
