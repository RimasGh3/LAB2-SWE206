import java.io.*;
import java.util.*;

public class GroupGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Generete Group by Number (enter 1 ) or by Max (enter 2) : ");
        int way = scanner.nextInt();
        if (way == 1) {
            System.out.print("Enter the number of groups to create: ");
            int numGroups = scanner.nextInt();

            List<String> studentNames = readStudentNamesFromFile(
                    "C:\\Users\\Rimas Alghamdi\\eclipse-workspace\\lab1-SWE206\\src\\Names.txt");

            List<List<String>> groups = generateGroupsByNum(studentNames, numGroups);

            for (int i = 0; i < groups.size(); i++) {
                System.out.println("Group " + (i + 1) + ": " + groups.get(i));
            }
        } else if (way == 2) {
            System.out.print("Enter the maximum number of students in each group: ");
            int maxStudentsInGroup = scanner.nextInt();

            List<String> studentNames = readStudentNamesFromFile(
                    "C:\\Users\\Rimas Alghamdi\\eclipse-workspace\\lab1-SWE206\\src\\Names.txt");

            List<List<String>> groups = generateGroupsByMax(studentNames, maxStudentsInGroup);

            for (int i = 0; i < groups.size(); i++) {
                System.out.println("Group " + (i + 1) + ": " + groups.get(i));
            }
        }

    }

    // Generates random groups from the list of student names
    private static List<List<String>> generateGroupsByNum(List<String> studentNames, int numGroups) {
        List<List<String>> groups = new ArrayList<>();

        // Shuffle the student names randomly
        Collections.shuffle(studentNames);

        int numStudents = studentNames.size();
        int groupSize = numStudents / numGroups;
        int remainingStudents = numStudents % numGroups;

        int currentIndex = 0;
        for (int i = 0; i < numGroups; i++) {
            int groupCount = groupSize;
            if (remainingStudents > 0) {
                groupCount++;
                remainingStudents--;
            }

            List<String> group = new ArrayList<>();
            for (int j = 0; j < groupCount; j++) {
                group.add(studentNames.get(currentIndex));
                currentIndex++;
            }

            groups.add(group);
        }

        return groups;
    }

}