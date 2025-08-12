package uk.gov.hmcts.taskmanager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDateTime;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    @Test
    void create_savesTask() {
        TaskRepository repo = Mockito.mock(TaskRepository.class);
        TaskService service = new TaskService(repo);

        Task t = new Task();
        t.setTitle("Write tests");
        when(repo.save(any(Task.class))).thenAnswer(inv -> inv.getArgument(0));

        Task saved = service.create(t);
        assertEquals("Write tests", saved.getTitle());
        verify(repo, times(1)).save(any(Task.class));
    }

    @Test
    void updateStatus_updates_whenExists() {
        TaskRepository repo = mock(TaskRepository.class);
        TaskService service = new TaskService(repo);

        Task t = new Task();
        t.setId(1L);
        t.setTitle("Demo");
        t.setStatus("PENDING");

        when(repo.findById(1L)).thenReturn(Optional.of(t));
        when(repo.save(any(Task.class))).thenAnswer(inv -> inv.getArgument(0));

        Task updated = service.updateStatus(1L, "COMPLETED");
        assertNotNull(updated);
        assertEquals("COMPLETED", updated.getStatus());
    }

    @Test
    void updateStatus_returnsNull_whenMissing() {
        TaskRepository repo = mock(TaskRepository.class);
        TaskService service = new TaskService(repo);

        when(repo.findById(999L)).thenReturn(Optional.empty());
        Task updated = service.updateStatus(999L, "COMPLETED");
        assertNull(updated);
    }
}

