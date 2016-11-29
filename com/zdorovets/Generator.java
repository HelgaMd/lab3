package com.zdorovets;
import java.util.Random;
/**
 * ����� ��� ��������� ������
 * @author Evgeny Zdorovets
 * Created on 29/11/16
 */
public class Generator {
	/**
     * ���������� �������� �������������
     * @param depCount ������������ ���-�� �������������
     */
    public void generateDepartments(int depCount) {
    	
            DepartmentName[] names = DepartmentName.values();
            DepartmentType[] types = DepartmentType.values();
            MainClass.departments = new Department[depCount];
            for (int i = 0; i < depCount; i++) {		
            	MainClass.departments[i] = new Department(names[i], types[i], i); // ����� ����� � ���� ������������� �� �������
                System.out.println("������� �������������: ��� - \"" + names[i] + "\", ��� - " + types[i] + " (������ - " + i + ")");
            }
        }
        /**
         * ���������� �������� ���������
         * @param classCount ������������ ���-�� ���������
         * @param depCount ������������ ���-�� �������������
         * @param maxArea ������������ ������� ���������
         */
    public void generateClasses(int classCount, int depCount, int maxArea) {
            ClassroomType[] cTypes = ClassroomType.values();
            Random random = new Random();
            MainClass.classrooms = new Classroom[classCount];
            for (int i = 0; i < classCount; i++) {
                int num = i + 1; // ����� ������ ���������
                ClassroomType type = cTypes[random.nextInt(cTypes.length)]; // ����� ���� ��������� ����. �������
                float area = random.nextFloat() * maxArea; // ����� ������� ��������� ����. �������
                int landingPlaceCount = Math.round(area) / 2; // ����� ���-�� �����. ���� ���������
                int departmentIndex = random.nextInt(depCount); // ����� ������������� ��������� ����. �������
                MainClass.classrooms[i] = new Classroom(num, type, area, landingPlaceCount, MainClass.departments[departmentIndex]);
                MainClass.departments[departmentIndex].getClasses().add(num); // ���������� ��������� � ������ ��������� �������������
                System.out.println("������� ���������: ����� - " + num + ", ��� - " + type + ", ������� - " + area + " ��.�., " +
                    "���������� ���������� ���� - " + landingPlaceCount + ", ������������� - " + departmentIndex);
            }
        }
}
