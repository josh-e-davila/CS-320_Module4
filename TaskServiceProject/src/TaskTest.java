import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskTest {
    @Test
    void testTaskCreation() {
        Task task = new Task("12345", "Task Name", "Task Description");
        assertEquals("12345", task.getTaskId());
        assertEquals("Task Name", task.getName());
        assertEquals("Task Description", task.getDescription());
    }

    @Test
    void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Task Name", "Task Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Task Name", "Task Description"));
    }

    @Test
    void testInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", null, "Task Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", "This name is too long for the field", "Task Description"));
    }

    @Test
    void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", "Task Name", null));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", "Task Name", "This description is way too long to be accepted by the program and should throw an exception"));
    }
}
