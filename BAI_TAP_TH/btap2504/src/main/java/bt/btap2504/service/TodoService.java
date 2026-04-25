package bt.btap2504.service;

import bt.btap2504.model.dto.TodoDTO;
import bt.btap2504.model.entity.Todo;
import bt.btap2504.repository.TodoRepository;
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
}