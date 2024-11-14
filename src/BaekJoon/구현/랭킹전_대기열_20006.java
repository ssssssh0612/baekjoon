package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 랭킹전_대기열_20006 {
    public static class Room {
        List<User> userList;
        int maxLevel;
        int lowLevel;
        boolean check;

        public Room(User user) {
            userList = new ArrayList<>();
            userList.add(user);
            maxLevel = user.level + 10;
            lowLevel = user.level - 10;
        }

        public void addUser(User user) {
            userList.add(user);
        }

        public boolean userChecking(int userCount) {
            if (userCount == userList.size()) {
                return true;
            }
            return false;
        }

        public boolean checking(int level) {
            return level <= maxLevel && level >= lowLevel;
        }

        public void started() {
            System.out.println("Started!");
            Collections.sort(userList);
            for (int i = 0; i < userList.size(); i++) {
                User user = userList.get(i);
                System.out.println(user.level + " " + user.name);
            }
        }

        public void waited() {
            System.out.println("Waiting!");
            Collections.sort(userList);
            for (int i = 0; i < userList.size(); i++) {
                User user = userList.get(i);
                System.out.println(user.level + " " + user.name);
            }
        }
    }

    public static class User implements Comparable<User> {
        String name;
        int level;

        public User(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(User other) {
            // name을 사전순으로 정렬하기 위해 compareTo 사용
            return this.name.compareTo(other.name);
        }
    }

    static int roomCount;
    static List<Room> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);

    }

    // 방의 정원이 모두 차면 게임을 시작시킨다.
    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int userCount = Integer.parseInt(st.nextToken());
        roomCount = Integer.parseInt(st.nextToken());
        List<User> nowUserList = new ArrayList<>();
        for (int i = 0; i < userCount; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            nowUserList.add(new User(level, name));
        }
//        System.out.println("nowUserList = " + nowUserList.size());
        for (int i = 0; i < userCount; i++) {
            User user = nowUserList.get(i);
            roomChecking(user);
            // 유저를 입력받고나서 방에 넣을 수 잇는지 없는지 체크하기
            // 방에 넣을수 없으면 방을 만들고 방에 넣어주기
            // 방에 넣을 수 있는데 방에 넣었더니 인원이 꽉 찬다면 started찍어주기 그리고 방 삭제
        }
        for (int i = 0; i < list.size(); i++) {
            Room room = list.get(i);
            if(room.userChecking(roomCount)){
                room.started();
            }else{
                room.waited();
            }
        }
        // 만약 남은 방이 있다면 waited 찍어주고 종료

    }

    public static void roomChecking(User user) {
        if (!list.isEmpty()) {
            // 방이 존재한다면 방 넣어주기
//            System.out.println("userLevel = " + user.level + "userName = " + user.name );
            // 그 전에 방에 들어갈 수 있는지 없는지 체크하기
            boolean checking = false;
            for (int i = 0; i < list.size(); i++) {
                Room room = list.get(i);
                if (room.checking(user.level) && !room.userChecking(roomCount)) {
                    checking = true;
                    room.addUser(user);
                }
                if (checking) {
                    break;
                }
            }
            if (!checking) {
//                System.out.println(user.name);
                Room room = new Room(user);
                list.add(room);
            }
            // 현재 들어갈 방이 없음 새 방 만들기
        } else {
            // 방이 존재하지 않는다면 방 만들어주기
            Room room = new Room(user);
            list.add(room);
        }
    }
}
