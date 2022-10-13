package io;

import models.Room;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IoFileRoom {
    public void writeFile(List<Room> rooms) {
        File file = new File("C:\\Users\\ADMIN\\IdeaProjects\\CaseMd2\\src\\io\\room.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Room room : rooms) {
                bufferedWriter.write(room.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("✅ Viết file phòng thành công !!!");
        } catch (IOException ioe) {
            System.err.println("⛔ File không tồn tại.");
        }
    }

    public List<Room> readFile() {
        List<Room> rooms = new ArrayList<>();
        File file = new File("C:\\Users\\ADMIN\\IdeaProjects\\CaseMd2\\src\\io\\room.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while (str != null) {
                String[] arr = str.split(",");
                String nameRoom = arr[0];
                double priceRoom = Double.parseDouble(arr[1]);
                String statusRoom = arr[2];
                int bedroomNumber = Integer.parseInt(arr[3]);
                int toiletNumber = Integer.parseInt(arr[4]);
                rooms.add(new Room(nameRoom, priceRoom, statusRoom, toiletNumber, bedroomNumber));
                str = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
            System.out.println("✅ Đọc file phòng thành công !!!");
        } catch (IOException ioe) {
            System.err.println("⛔ File không tồn tại.");
        }
        return rooms;
    }
}
