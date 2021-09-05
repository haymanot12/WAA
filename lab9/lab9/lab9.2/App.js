
import './App.css';
import Alert from './pages/HelloAlert';

function App() {
  return (
    <table>
      <th> <tr><Alert message ="Hello from button1"/></tr> <tr><Alert message ="Welcome from button3"/></tr></th>
      <th> <tr><Alert message="Hello from button2"/></tr> <tr><Alert message = "Welcome from button4 "/></tr></th>

    </table>
        
   
  );
}

export default App;
