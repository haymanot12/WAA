import './App.css';
import { ButtonComponent } from './pages/ButtonComponent';

function App() {
  return (
    <div>
      <header>
        <p>
          <table>
            <tr>
              <td><ButtonComponent message={"Hello from button 1"}/></td>
              <td><ButtonComponent message={"Welcome from button 1"}/></td>
            </tr>
            <tr>
              <td><ButtonComponent message={"Hi from button 3"}/></td>
              <td><ButtonComponent message={"Goodby from button 4"}/></td>
            </tr>
          </table>
        </p>
      </header>
    </div>
  );
}

export default App;
