import React, { Component } from 'react';
import AppCake from './components/cake/AppCake'
import './App.css';
import './bootstrap.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <AppCake />
      </div>
    );
  }
}

export default App;