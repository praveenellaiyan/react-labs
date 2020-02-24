import React from 'react'

export default function Todo({todo, togglefunc}) {

    function handleCheckboxToggle() {
        togglefunc(todo.id)
    }

    return (
        <div>
            <input type="checkbox" checked={todo.complete} onChange={handleCheckboxToggle}/>
            <label>{todo.name}</label>
        </div>
    )
}
