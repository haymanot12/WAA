import React from 'react';

function alertfun(probs) {
    const displayhello = ()=>{
        alert(probs.message)
    }
  return (
    <div >
      <header>
       
        <p>
          <button onClick = {displayhello}>{probs.message}</button>
        </p>
        
      </header>
    </div>
  );
}

export default alertfun;