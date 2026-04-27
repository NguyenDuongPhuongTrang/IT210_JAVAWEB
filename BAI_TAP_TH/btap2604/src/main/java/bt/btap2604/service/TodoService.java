package bt.btap2604.service;

import bt.btap2604.model.dto.TodoDTO;
import bt.btap2604.model.entity.Todo;
import bt.btap2604.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    private Todo mapTodo(TodoDTO todoDTO) {
        return new Todo(
                todoDTO.getId(),
                todoDTO.getContent(),
                todoDTO.getDueDate(),
                todoDTO.getStatus(),
                todoDTO.getPriority()
        );
    }

    public void addToDo(TodoDTO todoDTO) {
        Todo todo = mapTodo(todoDTO);
        todoRepository.save(todo);
    }

    public void updateTodo(Long id, TodoDTO todoDTO) {
        todoDTO.setId(id);
        Todo todo = mapTodo(todoDTO);
        todoRepository.save(todo);
    }

    public Todo findById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
