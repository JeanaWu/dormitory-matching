package com.juan.springboot.Algorithm;

import com.juan.springboot.bean.Student;
import com.juan.springboot.mapper.RoomMapper;


import java.util.*;


public class Greedy {



    /**
     * 获取学生的权重并存保存在students中
     */
    public void getWeight(ArrayList<Student> students) {
//        System.out.println(students.size());
        for (int i = 0; i < students.size(); i++) {
            int stuWeight = students.get(i).getStuHabits().getSlpTime() * 10
                    + students.get(i).getStuHabits().getGupTime() * 8
                    + students.get(i).getStuHabits().getSlpNoisy() * 5
                    + students.get(i).getStuHabits().getSlpHabits() * 6
                    + students.get(i).getStuHabits().getClean() * 4
                    + students.get(i).getStuHabits().getGames() * 4
                    + students.get(i).getStuHabits().getAtmos() * 3
                    + students.get(i).getStuHabits().getCharacters() * 2;
//            System.out.println(stuWeight);
            students.get(i).setWeight(stuWeight);
        }
    }

    /**
     * 随机取出一个女生，并排序分配
     */
    public void greedyFSelector(ArrayList<Student> students, RoomMapper roomMapper) {
        //获取标准值

        Random random = new Random();


        //每分配一次宿舍。删除这四个学生。再次循环
        while (students.size() != 0) {


            for(int a=students.size()-1;a>=0;a--) {

                int id = students.get(a).getId();
                String roomid = roomMapper.getRoomById(id);
                if (roomid != null) {
                    students.remove(a);
                    System.out.println("该学生已经分配宿舍++++++++++++");
                }
            }

            System.out.println("此时没有分配的人数为"+students.size());



                int n = random.nextInt(students.size());
                int stander = students.get(n).getWeight();


                for (int j = 0; j < students.size(); j++) {
                    int difference = (Math.abs(stander - students.get(j).getWeight()));
                    students.get(j).setDifference(difference);
                    if (students.get(0).getGender() == 1) students.get(j).setBuilding(1);//男生分配在1栋
                    else students.get(j).setBuilding(0);//女生分配在2栋

                }

                //根据和标准的差值排序
                Collections.sort(students, Comparator.comparing(Student::getDifference));

                Integer room = roomMapper.getfMaxRoom();
                System.out.println(room);
                if (room == null) {
                    room =101 ;
                    System.out.println(room);
                } else room = room+1;
                System.out.println(room);

                for (int m = 0; m < 4; m++) {
                    if (students.size() != 0) {
                        students.get(0).setRoom(room);

                        //存储到数据库room表中
                        roomMapper.saveRoom(students.get(0).getRoom(), students.get(0).getId(), students.get(0).getWeight(),students.get(0).getBuilding());

                        //移除students第一位元素
                        students.remove(0);
                    }
                }
                System.out.println("宿舍分配结束++++++++++++++++++++");

        }

    }

    /**
     * 随机取出一个男生，并排序分配
     */
    public void greedyMSelector(ArrayList<Student> students, RoomMapper roomMapper) {
        //获取标准值

        Random random = new Random();


        //每分配一次宿舍。删除这四个学生。再次循环
        while (students.size() != 0) {


            for(int a=students.size()-1;a>=0;a--) {

                int id = students.get(a).getId();
                String roomid = roomMapper.getRoomById(id);
                if (roomid != null) {
                    students.remove(a);
                    System.out.println("该学生已经分配宿舍++++++++++++");
                }
            }

            System.out.println("此时没有分配的人数为"+students.size());



            int n = random.nextInt(students.size());
            int stander = students.get(n).getWeight();


            for (int j = 0; j < students.size(); j++) {
                int difference = (Math.abs(stander - students.get(j).getWeight()));
                students.get(j).setDifference(difference);
//                if (students.get(0).getGender() == 1) students.get(j).setBuilding(1);//男生分配在1栋
//                else students.get(j).setBuilding(0);//女生分配在2栋
                students.get(j).setBuilding(1);
            }

            //根据和标准的差值排序
            Collections.sort(students, Comparator.comparing(Student::getDifference));

            Integer room = roomMapper.getmMaxRoom();
            System.out.println(room);
            if (room == null) {
                room =101 ;
                System.out.println(room);
            } else room = room+1;
            System.out.println(room);

            for (int m = 0; m < 4; m++) {
                if (students.size() != 0) {
                    students.get(0).setRoom(room);

                    //存储到数据库room表中
                    roomMapper.saveRoom(students.get(0).getRoom(), students.get(0).getId(), students.get(0).getWeight(),students.get(0).getBuilding());

                    //移除students第一位元素
                    students.remove(0);
                }
            }
            System.out.println("宿舍分配结束++++++++++++++++++++");

        }

    }

}
