import React, {Component} from 'react';
import './App.css';
import Dashboard from './components/Dahsboard'
import Header from "./components/Layouts/Header";


class App extends Component {
    render() {
        return (
            <div className="App">
                <Header/>
                <Dashboard/>
            </div>
        );
    }
}

export default App;
