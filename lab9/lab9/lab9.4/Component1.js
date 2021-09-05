import React from 'react'


function Component1({increOrDecre,count}) {


    let increment = ()=>{
      increOrDecre(count++);

    }
    let decrement =()=>{

     increOrDecre(count--);
    
    }

  return (
    <div>
      <header>
        <p>
            <button onClick={increment}>+1</button>
            <button onClick={decrement}>-1</button>
        </p>
      </header>
    </div>
  );
}

export default Component1;
