import './App.css';
import Nav from './component/Nav.js';
import UploadForm from './component/UploadForm';

function App() {
  return (
    <div className="App">
      {<Nav />}
      {<UploadForm />}
    </div>
  );
}

export default App;
