import React, {Component} from 'react'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import CakeList from './CakeList.jsx'
import Cake from './Cake.jsx'

class AppCake extends Component {
    render() {
        return (
            <div className="AppCake">
                <Router>
                    <Switch>
                        <Route path="/" exact component={CakeList}/>
                        <Route path="/cakes/add" component={Cake}/>
                        <Route path="/cakes" component={CakeList}/>
                    </Switch>
                </Router>
            </div>
        )
    }
}

export default AppCake