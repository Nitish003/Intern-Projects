import java.io.*;
import java.net.*;
import java.util.Scanner;

class ChatApplication {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                runServer();
            } else {
                runClient(args[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void runServer() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Chat server started on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received message: " + message);
                    writer.println("Server: " + message);
                    writer.flush();
                }

                clientSocket.close();
            }
        }
    }

    private static void runClient(String serverAddress) throws IOException {
        @SuppressWarnings("resource")
        Socket clientSocket = new Socket(serverAddress, PORT);
        System.out.println("Chat client connected to server: " + clientSocket.getInetAddress());

        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter message: ");
            String message = scanner.nextLine();
            writer.println(message);
            writer.flush();

            String serverMessage = reader.readLine();
            System.out.println("Server: " + serverMessage);
            scanner.close();
        }
        
    }
    }
   