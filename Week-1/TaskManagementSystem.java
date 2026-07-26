//Exercise 5: Task Management System

class Task {

    int taskId;
    String taskName;
    String status;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String toString() {
        return taskId + " " + taskName + " " + status;
    }
}

class Node {
    Task task;
    Node next;

    Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManagementSystem {

    Node head = null;

    void addTask(Task task) {

        Node newNode = new Node(task);

        if(head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while(temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    void searchTask(int id) {

        Node temp = head;

        while(temp != null) {

            if(temp.task.taskId == id) {
                System.out.println(temp.task);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Task Not Found");
    }

    void traverseTasks() {

        Node temp = head;

        while(temp != null) {

            System.out.println(temp.task);
            temp = temp.next;
        }

        System.out.println();
    }

    void deleteTask(int id) {

        if(head == null)
            return;

        if(head.task.taskId == id) {

            head = head.next;
            System.out.println("Task Deleted");
            return;
        }

        Node temp = head;

        while(temp.next != null && temp.next.task.taskId != id)
            temp = temp.next;

        if(temp.next == null) {

            System.out.println("Task Not Found");
            return;
        }

        temp.next = temp.next.next;

        System.out.println("Task Deleted");
    }

    public static void main(String[] args) {

        TaskManagementSystem tms = new TaskManagementSystem();

        tms.addTask(new Task(101, "Design UI", "Pending"));
        tms.addTask(new Task(102, "Develop API", "In Progress"));
        tms.addTask(new Task(103, "Testing", "Pending"));

        System.out.println("All Tasks:");
        tms.traverseTasks();

        System.out.println("Search Task:");
        tms.searchTask(102);

        tms.deleteTask(102);

        System.out.println("\nAfter Deletion:");
        tms.traverseTasks();
    }
}
