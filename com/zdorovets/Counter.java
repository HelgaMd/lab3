package com.zdorovets;
/**
 * ����� ��� �������� ������
 * @author Evgeny Zdorovets
 * Created on 29/11/16
 */
public class Counter {
    /**
     * ������� ������ ��������� �� ���� ��������������
     * @param classCount ������������ ���-�� ���������
     * @param depCount ������������ ���-�� �������������
     */
public void getClassroomNumbersByDepartments(int classCount, int depCount) {
		int size;
        for (int i = 0; i < depCount; i++) {
            System.out.println(MainClass.departments[i]);
            size = MainClass.departments[i].getClasses().size();
            for (int j = 0; j < size; j++)
                System.out.println(MainClass.classrooms[MainClass.departments[i].getClasses().get(j)-1]);
        }
    }
    /**
     * ������������ ������� ������� ��������� �� ����������
     * @param classCount ������������ ���-�� ���������
     */
public void getAreaByClassrooms(int classCount) {
        int sum = 0;
        for (int i = 0; i < classCount; i++) {            	
            if (MainClass.classrooms[i].getType().equals(ClassroomType.���������))
                sum += MainClass.classrooms[i].getArea();
        }
        System.out.println("����� ������� ��������� - " + sum + " ��.�.");
    }
    /**
     * ������������ ������� ���� ��������� �� �������� ���������
     * @param classCount ������������ ���-�� ���������
     */
public void getAllAreas(int classCount) {
        int sum = 0;
        for (int i = 0; i < classCount; i++) {
            sum += MainClass.classrooms[i].getArea();
        }
        System.out.println("����� ������� ��������� �� ����� ��������� - " + sum + " ��.�.");
    }
    /**
     * �� ������� ������������� ������������ ���������� ���������� ���� �� ��������������
     * @param departmentIndex ������ �������������
     * @param classCount ������������ ���-�� ���������
     * @return ���������� ���������� ���� �� ��������������
     */
public int getLandingPlacesByDepartment(int departmentIndex, int classCount) {
        int sum = 0;
        for (int j = 0; j < classCount; j++) {
            if (MainClass.classrooms[j].getDepartment().equals(MainClass.departments[departmentIndex])) {
                sum += MainClass.classrooms[j].getLandingPlaceCount();
            }
        }
        return sum;
    }
    /**
     * ������� ������ ���������� ���� �� ��������������
     * @param classCount ������������ ���-�� ���������
     * @param depCount ������������ ���-�� �������������
     */
public void getLandingPlacesByDepartments(int classCount, int depCount) {
        int landingPlaces;
        for (int i = 0; i < depCount; i++) {
            System.out.print(MainClass.departments[i]);
            landingPlaces = getLandingPlacesByDepartment(i, classCount);
            System.out.println("���������� ���������� ���� - " + landingPlaces);
        }
    }
}
