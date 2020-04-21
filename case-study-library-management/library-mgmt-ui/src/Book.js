import React from 'react'

export default function Book({book}) {
    return (
        <div>
            {book.name} | {book.author} | {book.category} | {book.publishedOn}
        </div>
    )
}
