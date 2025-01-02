import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {
            System.out.println("Enter an action (add, update, delete, list, list todo, list done, list in-progress):");
            String action = sc.nextLine().toLowerCase().trim();

            if (action.equals("exit")) {
                System.out.println("Bye!");
                break;
            }

            switch (action) {
                case "add":
                    System.out.println("Enter task description:");
                    String description = sc.nextLine();
                    System.out.println("Enter task status (TODO, IN_PROGRESS, DONE):");
                    String status = sc.nextLine().toUpperCase();
                    try {
                        Status taskStatus = Status.valueOf(status);
                        tasks.add(new Task(description, taskStatus));
                        System.out.println("Task added successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid status. Please enter TODO, IN_PROGRESS, or DONE.");
                    }
                    break;

                case "update":
                    System.out.println("Enter task ID:");
                    int updateId = sc.nextInt();
                    sc.nextLine(); // Consume leftover newline
                    Task taskToUpdate = findTaskById(tasks, updateId);
                    if (taskToUpdate != null) {
                        System.out.println("Enter new description:");
                        String newDescription = sc.nextLine();
                        System.out.println("Enter new status (TODO, IN_PROGRESS, DONE):");
                        String newStatus = sc.nextLine().toUpperCase();
                        try {
                            Status newTaskStatus = Status.valueOf(newStatus);
                            taskToUpdate.setDescription(newDescription);
                            taskToUpdate.setStatus(newTaskStatus);
                            taskToUpdate.setUpdatedAt(LocalDateTime.now());
                            System.out.println("Task updated successfully.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid status. Please enter TODO, IN_PROGRESS, or DONE.");
                        }
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                case "delete":
                    System.out.println("Enter task ID:");
                    int deleteId = sc.nextInt();
                    sc.nextLine(); // Consume leftover newline
                    Task taskToDelete = findTaskById(tasks, deleteId);
                    if (taskToDelete != null) {
                        tasks.remove(taskToDelete);
                        System.out.println("Task deleted successfully.");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                case "list":
                    System.out.println("All tasks:");
                    tasks.forEach(System.out::println);
                    break;

                case "list done":
                    System.out.println("Done tasks:");
                    tasks.stream()
                            .filter(task -> task.getStatus() == Status.DONE)
                            .forEach(System.out::println);
                    break;

                case "list todo":
                    System.out.println("Todo tasks:");
                    tasks.stream()
                            .filter(task -> task.getStatus() == Status.TODO)
                            .forEach(System.out::println);
                    break;

                case "list in-progress":
                    System.out.println("In-progress tasks:");
                    tasks.stream()
                            .filter(task -> task.getStatus() == Status.IN_PROGRESS)
                            .forEach(System.out::println);
                    break;

                default:
                    System.out.println("Invalid action. Please try again.");
            }
        }
    }

    private static Task findTaskById(ArrayList<Task> tasks, int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }
}
