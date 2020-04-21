import React from 'react'

export default function Library({library, toggleLibrary}) {
    return (
        <div id={library.libraryId} key={library.libraryId} onClick={toggleLibrary}>
            {library.name} | {library.address }
        </div>
    )
}
