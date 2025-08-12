package uk.gov.hmcts.taskmanager;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repo;

    public TaskService(TaskRepository repo) { this.repo = repo; }

    public Task create(Task t) { return repo.save(t); }

    public Task get(Long id) { return repo.findById(id).orElse(null); }

    public List<Task> all() { return repo.findAll(); }

    public Task updateStatus(Long id, String status) {
        return repo.findById(id).map(t -> {
            t.setStatus(status);
            return repo.save(t);
        }).orElse(null);
    }

    public boolean delete(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}

