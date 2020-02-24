import React, {useState, useRef, useEffect} from 'react';
import Todolist from './Todolist'
import uuid from 'uuid'

const LOCAL_STRG_TODO = "todos"

function App() {
  const [todos, setTodos] = useState([])
  const todoInputEleRef = useRef()

  function handleToggle(id) {
    let newTodo = [...todos]
    let foundTodo = newTodo.find(todo => todo.id === id)
    foundTodo.complete = !foundTodo.complete
    setTodos(newTodo)
  }

  useEffect(() => {
    const todos = localStorage.getItem(LOCAL_STRG_TODO)
    setTodos(JSON.parse(todos))
  }, [])

  useEffect(() => {
    localStorage.setItem(LOCAL_STRG_TODO, JSON.stringify(todos))
  }, [todos])

  function handleAddTodo(e) {
    const newTodo = todoInputEleRef.current.value
    setTodos(prevTodos => {
      return [...prevTodos, {id: uuid(), name: newTodo, complete: false}]
    })
    todoInputEleRef.current.value = null
  }

  function handleRemoveTodo() {
    let todoToComplete = todos.filter(todo => {
      return !todo.complete
    })
    setTodos(todoToComplete)
  }


  return (
    <>
      Todo List
      <hr/>
      <Todolist todos={todos} togglefunc={handleToggle}/>
      <input type="text" ref={todoInputEleRef}/>
      <input type="button" value="Add Todo" onClick={handleAddTodo}/>
      <input type="button" value="Remove Completed Todo" onClick={handleRemoveTodo}/>
    </>
  );
}

export default App;
