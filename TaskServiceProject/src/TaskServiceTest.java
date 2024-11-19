import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
    @Test
    void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Task Name", "Task Description");
        service.addTask(task);
        assertEquals(task, service.getTask("12345"));
    }

    @Test
    void testAddDuplicateTask() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Task Name", "Task Description");
        service.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> service.addTask(task));
    }

    @Test
    void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Task Name", "Task Description");
        service.addTask(task);
        service.deleteTask("12345");
        assertNull(service.getTask("12345"));
    }

    @Test
    void testUpdateTaskName() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Task Name", "Task Description");
        service.addTask(task);
        service.updateTaskName("12345", "New Task Name");
        assertEquals("New Task Name", service.getTask("12345").getName());
    }

    @Test
    void testUpdateTaskDescription() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Task Name", "Task Description");
        service.addTask(task);
        service.updateTaskDescription("12345", "New Task Description");
        assertEquals("New Task Description", service.getTask("12345").getDescription());
    }
}
