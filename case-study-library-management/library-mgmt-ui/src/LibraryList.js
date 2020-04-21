import React, {useEffect, useState} from 'react'
import axios from 'axios';
import Library from './Library';
import Book from './Book';

export default function LibraryList() {

    const libraryBaseApi = 'http://localhost:8081/library/'
    const libAll = 'all'

    const allLibraryDetails = libraryBaseApi+libAll

    const [libraries, setlibraries] = useState([])
    const [currentLibraryBooks, setCurrentLibraryBooks] = useState(libraryBaseApi + '1')
    const [books, setBooks] = useState([])

    useEffect(() => {
        axios.get(allLibraryDetails).then(res => {
            setlibraries(res.data)
        })
        fetchBookDetails()
    }, [])

    useEffect(() => {
        fetchBookDetails()
    }, [currentLibraryBooks])

    function fetchBookDetails() {
        axios.get(currentLibraryBooks).then(res => {
            setBooks(res.data)
        })
    }

    function toggleLibrary(e) {
        setCurrentLibraryBooks(libraryBaseApi + e.target.id)
    }

    return (
        <>  
            <h2>Library List</h2>          
            {
                libraries.map(library => {                
                    return (                        
                        <Library key={library.libraryId} library={library} toggleLibrary={toggleLibrary}/>
                    )
                })
            }
        
            <h2>Book Details</h2>
            <br/>
            {
                books.map(book => {
                    return (
                        <Book book={book} key={book.bookId}/>
                    )
                })
            }
        </>
    )
}
