
import './App.css';

import { BrowserRouter as Router, Route } from 'react-router-dom'; 

import Home from "./pages/Home";
import Layout from "./components/common/Layout";
import { PATH } from "./utils/Constants"
function App() {
    return (
        <div className="App">
            <Router>
                <Layout>
                    <Home />
                </Layout>
            </Router>
        </div>
    );
}

export default App;
