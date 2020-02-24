import React from 'react'
import Todo from './Todo'

export default function Todolist({todos, togglefunc}) {
    return (
        todos.map(todo => {
        return <Todo key={todo.id} todo={todo} togglefunc={togglefunc}/>
    })
    )
}
